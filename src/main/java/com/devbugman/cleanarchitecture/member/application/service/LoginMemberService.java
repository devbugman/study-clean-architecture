package com.devbugman.cleanarchitecture.member.application.service;

import com.devbugman.cleanarchitecture.member.application.port.in.LoginMemberUseCase;
import com.devbugman.cleanarchitecture.member.application.port.out.MemberPort;
import com.devbugman.cleanarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginMemberService implements LoginMemberUseCase {
    private final MemberPort memberPort;

    @Override
    public Member login(final String nickname, final String password) {
        final var member = memberPort.findByNickname(nickname);
        if (!member.password().equals(password)) {
            //TODO Exception
            throw new IllegalArgumentException();
        }
        return member;
    }
}
