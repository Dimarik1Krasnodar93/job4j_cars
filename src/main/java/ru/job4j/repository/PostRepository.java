package ru.job4j.repository;

import ru.job4j.cars.model.Mark;
import ru.job4j.toone.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getPostsForLastDay();
    List<Post> getPostsWithPhoto();
    List<Post> getPostsByMark(Mark mark);
    List<Post> getAllPosts();
}
