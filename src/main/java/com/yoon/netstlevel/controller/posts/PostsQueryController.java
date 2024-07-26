package com.yoon.netstlevel.controller.posts;

import com.yoon.netstlevel.common.response.CommonResponse;
import com.yoon.netstlevel.common.pagequery.PageQueryRequest;
import com.yoon.netstlevel.domain.posts.Posts;
import com.yoon.netstlevel.dto.posts.PostsPageResponse;
import com.yoon.netstlevel.dto.posts.PostsQueryResponse;
import com.yoon.netstlevel.repository.posts.PostsQueryFilter;
import com.yoon.netstlevel.service.posts.PostsQueryService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostsQueryController {
    private final PostsQueryService postsQueryService;

    @GetMapping("{postsId}")
    public CommonResponse<PostsQueryResponse> queryOne(
            @PathVariable("postsId") Long postsId
    ) {
        Posts posts = postsQueryService.queryOne(postsId);
        return CommonResponse.success(new PostsQueryResponse(posts));
    }

    @GetMapping("page")
    public CommonResponse<PostsPageResponse> queryPage(
            @ParameterObject PostsQueryFilter filter,
            @ParameterObject PageQueryRequest pageQueryRequest
    ) {
        PostsPageResponse postsPageResponse = postsQueryService.queryPage(
                pageQueryRequest.toPageable(),
                filter
        );
        return CommonResponse.success(postsPageResponse);
    }
}
