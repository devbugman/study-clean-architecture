package com.devbugman.cleanarchitecture.member.application.port.out;

import com.devbugman.cleanarchitecture.member.domain.Member;

import java.util.List;

public interface MemberPort {
    Long save(Member member);


    void delete(Long id);

    void update(Long id, Member member);

    List<Member> read();

    Member readOne(Long id);

    Member findByNickname(String nickname);
}
