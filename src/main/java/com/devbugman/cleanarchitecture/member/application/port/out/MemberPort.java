package com.devbugman.cleanarchitecture.member.application.port.out;

import com.devbugman.cleanarchitecture.member.domain.Member;

public interface MemberPort {
    Long save(Member member);


    void delete(Long id);

    void update(Long id, Member member);

    Member readOne(Long id);

    Member findByNickname(String nickname);
}
