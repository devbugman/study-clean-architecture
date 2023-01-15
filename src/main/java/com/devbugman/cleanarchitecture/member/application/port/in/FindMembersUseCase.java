package com.devbugman.cleanarchitecture.member.application.port.in;

import com.devbugman.cleanarchitecture.member.domain.Member;

import java.util.List;

public interface FindMembersUseCase {
    List<Member> findMembers();
}
