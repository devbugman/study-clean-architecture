package com.devbugman.cleanarchitecture.member.adapter.in.web.request;

import lombok.Getter;

public record RegisterMemberRequest(
        String nickname,
        String password,
        String checkPassword
) {

}
