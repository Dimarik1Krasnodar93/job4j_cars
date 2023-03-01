package ru.job4j.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Mark;
import ru.job4j.toone.Post;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class HibernatePostRepository implements PostRepository {
    private final SessionFactory sessionFactory;
    private final CrudRepository crudRepository;
    private static final String FIND_ALL_POSTS = "SELECT p from Post P";
    public static final String FIND_POSTS_LAST_DAY = "SELECT c FROM Car As c WHERE c.created BETWEEN :dateTimeStart AND :dateTimeEnd";
    public static final String FIND_POSTS_WITH_PHOTO = "SELECT c FROM Car As c WHERE c.photo != NULL";
    public static final String FIND_POSTS_WITH_MARK = "SELECT c FROM Car As c c.mark_id = :mark_id";



    @Override
    public List<Post> getPostsForLastDay() {
        LocalDateTime dateTimeEnd = LocalDateTime.now();
        LocalDateTime dateTimeStart = dateTimeEnd.minusDays(1);
        Timestamp timestamp = Timestamp.valueOf(LocalDate.EPOCH.atStartOfDay());
        Map<String, Object> map = new HashMap<>();
        map.put("dateTimeStart", Timestamp.valueOf(dateTimeStart));
        map.put("dateTimeEnd", Timestamp.valueOf(dateTimeEnd));
        return crudRepository.query(FIND_POSTS_LAST_DAY, Post.class, map);
    }

    @Override
    public List<Post> getPostsWithPhoto() {
        return crudRepository.query(FIND_POSTS_WITH_PHOTO, Post.class, new HashMap<>());
    }

    @Override
    public List<Post> getPostsByMark(Mark mark) {
        Map<String, Object> map = new HashMap<>();
        map.put("mark_id", mark.getId());
        return crudRepository.query(FIND_POSTS_WITH_MARK, Post.class, map);
    }

    @Override
    public List<Post> getAllPosts() {
        return crudRepository.query(FIND_ALL_POSTS, Post.class, new HashMap<>());
    }
}
