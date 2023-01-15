package com.devbugman.cleanarchitecture.member.application.service;

import com.devbugman.cleanarchitecture.member.application.port.in.RegisterMemberUseCase;
import com.devbugman.cleanarchitecture.member.application.port.out.ExitstNicknamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberValidator {
    private final ExitstNicknamePort nicknamePort;

    public void validate(RegisterMemberUseCase.RegisterMemberCommend commend) {
        validateEmail(commend.nickname());
        validatePassword(commend.password(), commend.checkPassword());
    }

    private void validatePassword(final String password, final String checkPassword) {
        if (password == null || password.length() < 8) {
            // TODO Exception
            throw new IllegalArgumentException();
        }

        if (!password.equals(checkPassword)) {
            // TODO Exception
            throw new IllegalArgumentException();
        }
    }

    private void validateEmail(final String nickname) {
        if (nickname == null || nickname.length() < 2) {
            // TODO Exception
            throw new IllegalArgumentException();
        }

        if (nicknamePort.existNickname(nickname)) {
            // TODO Exception
            throw new IllegalArgumentException();
        }
    }
}
