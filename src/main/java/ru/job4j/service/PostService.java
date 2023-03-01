package ru.job4j.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.repository.CrudRepository;
import ru.job4j.repository.PostRepository;
import ru.job4j.toOne.Post;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    PostRepository postRepository;
    private final CrudRepository crudRepository;

    private static final String FIND_ALL_POSTS = "SELECT p from Post P";

    public List<Post> getAllPosts() {
        return crudRepository.query(FIND_ALL_POSTS, Post.class, new HashMap<>());
    }
}
