package com.yoon.netstlevel.dto.posts;

import com.yoon.netstlevel.common.pagequery.PageInfoResponse;
import com.yoon.netstlevel.common.pagequery.PageResponse;
import com.yoon.netstlevel.domain.posts.Posts;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PostsPageResponse extends PageResponse {
    private List<PostsQueryResponse> posts;

    public PostsPageResponse(
            PageInfoResponse pageInfo,
            List<Posts> posts
    ){
        super(pageInfo);
        this.posts = posts.stream()
                .map(PostsQueryResponse::new)
                .toList();
    }
}