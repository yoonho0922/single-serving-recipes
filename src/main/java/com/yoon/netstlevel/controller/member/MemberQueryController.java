package com.yoon.netstlevel.controller.member;

import com.yoon.netstlevel.service.member.MemberQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/member")
public class MemberQueryController {

    private final MemberQueryService memberQueryService;

}
