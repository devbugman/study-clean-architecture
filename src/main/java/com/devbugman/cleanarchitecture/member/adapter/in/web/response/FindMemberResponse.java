package com.devbugman.cleanarchitecture.member.adapter.in.web.response;

/**
 * 회원 조회 response
 */
public record FindMemberResponse(
        Long id,
        String nickname,
        String role,
        String status
) {
}
