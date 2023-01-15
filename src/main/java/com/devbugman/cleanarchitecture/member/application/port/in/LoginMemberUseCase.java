package com.devbugman.cleanarchitecture.member.application.port.in;

import com.devbugman.cleanarchitecture.member.domain.Member;

public interface LoginMemberUseCase {
    Member login(String nickname, String password);
}
