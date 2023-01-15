package com.devbugman.cleanarchitecture.member.application.service;

import com.devbugman.cleanarchitecture.member.application.port.in.QueryMemberByIdUseCase;
import com.devbugman.cleanarchitecture.member.application.port.out.MemberPort;
import com.devbugman.cleanarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 단건 조회
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryMemberService implements QueryMemberByIdUseCase {
    private final MemberPort memberPort;

    @Override
    public Member queryMemberById(final Query query) {
        return memberPort.readOne(query.id());
    }
}
