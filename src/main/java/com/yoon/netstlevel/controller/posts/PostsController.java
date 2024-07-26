package com.yoon.netstlevel.controller.posts;

import com.yoon.netstlevel.common.response.CommonResponse;
import com.yoon.netstlevel.dto.posts.PostsCreateRequest;
import com.yoon.netstlevel.service.posts.PostsService;
import com.yoon.netstlevel.dto.posts.PostsUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/posts")
public class PostsController {
    private final PostsService postsService;

    @PostMapping
    public CommonResponse<Long> save(
            @RequestBody PostsCreateRequest request
    ) {
        Long postsId = postsService.create(request);
        return CommonResponse.success(postsId);
    }

    @PutMapping("{postsId}")
    public CommonResponse<Long> update(
            @PathVariable("postsId") Long postsId,
            @RequestBody PostsUpdateRequest request
    ) {
        Long updatedPostsId = postsService.update(postsId, request);
        return CommonResponse.success(updatedPostsId);
    }

    @DeleteMapping("{postsId}")
    public CommonResponse<Object> delete(
            @PathVariable("postsId") Long postsId
    ) {
        postsService.delete(postsId);
        return CommonResponse.success(null);
    }
}
