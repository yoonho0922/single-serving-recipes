package com.yoon.netstlevel.repository.member;

import com.yoon.netstlevel.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberCustomRepository {
}
