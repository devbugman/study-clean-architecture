package com.devbugman.cleanarchitecture.member.application.service;

import com.devbugman.cleanarchitecture.member.application.port.in.RegisterMemberUseCase;
import com.devbugman.cleanarchitecture.member.application.port.out.MemberPort;
import com.devbugman.cleanarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {

    private final MemberPort memberPort;
    private final MemberValidator memberValidator;

    @Override
    public Long registerMember(final RegisterMemberCommend commend) {
        memberValidator.validate(commend);
        return memberPort.save(Member.newMember(commend.nickname(), commend.password()));
    }
}
