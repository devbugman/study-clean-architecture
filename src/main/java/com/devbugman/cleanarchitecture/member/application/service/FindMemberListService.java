package com.devbugman.cleanarchitecture.member.application.service;

import com.devbugman.cleanarchitecture.member.application.port.in.FindMembersUseCase;
import com.devbugman.cleanarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 회원리스트 조회
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindMemberListService implements FindMembersUseCase {
    @Override
    public List<Member> findMembers() {
        return null;
    }
}
