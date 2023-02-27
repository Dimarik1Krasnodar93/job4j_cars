package ru.job4j.repository;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.model.Mark;
import ru.job4j.toone.Post;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class HibernatePostRepository implements PostRepository {
    private final SessionFactory sessionFactory;
    private final CrudRepository crudRepository;
    public static final String FIND_POSTS_LAST_DAY = "SELECT c FROM Car As c WHERE c.created > :dayStart";
    public static final String FIND_POSTS_WITH_PHOTO = "SELECT c FROM Car As c WHERE c.photo != NULL";
    public static final String FIND_POSTS_WITH_MARK = "SELECT c FROM Car As c c.mark_id = :mark_id";



    @Override
    public List<Post> getPostsForLastDay() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(),
                LocalTime.of(0, 0)));
        Map<String, Object> map = new HashMap<>();
        map.put("dayStart", timestamp);
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
}
