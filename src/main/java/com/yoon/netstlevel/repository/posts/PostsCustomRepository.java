package com.yoon.netstlevel.repository.posts;

import com.yoon.netstlevel.domain.posts.Posts;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostsCustomRepository {
    Optional<Posts> findPosts(PostsQueryFilter filter);
    List<Posts> findPostsList(PostsQueryFilter filter);
    List<Posts> findPostsPage(Pageable pageable, PostsQueryFilter filter);
    Long countPosts(PostsQueryFilter filter);
}