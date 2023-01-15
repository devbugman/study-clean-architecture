package com.devbugman.cleanarchitecture.member.application.port.in;

public interface RegisterMemberUseCase {
    Long registerMember(final RegisterMemberCommend commend);

    record RegisterMemberCommend(
            String nickname,
            String password,
            String checkPassword
    ){
    }
}
