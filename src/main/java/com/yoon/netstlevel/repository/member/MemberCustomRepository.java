package com.yoon.netstlevel.repository.member;

import com.yoon.netstlevel.domain.member.Member;

public interface MemberCustomRepository {
    Member findMember(Long memberId);
    Member findMember(String name, String email);
}
