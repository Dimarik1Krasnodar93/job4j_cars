package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.repository.CrudRepository;
import ru.job4j.repository.PostRepository;
import ru.job4j.toone.Post;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class PostService {
    private PostRepository postRepository;
    private final CrudRepository crudRepository;


    public List<Post> getAllPosts() {

        return postRepository.getAllPosts();
    }

    public void update(Post post) {
        postRepository.update(post);
    }

    public Post findById(int id) {
        return postRepository.findById(id);
    }

    public void addPost(Post post) {
        post.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        postRepository.save(post);
    }
}
