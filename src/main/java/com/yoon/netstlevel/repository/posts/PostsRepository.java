package com.yoon.netstlevel.repository.posts;

import com.yoon.netstlevel.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>, PostsCustomRepository {
}
