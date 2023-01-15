package com.devbugman.cleanarchitecture.member.adapter.in.web.request;

public record LoginMemberRequest(
        String nickname,
        String password
) {
}
