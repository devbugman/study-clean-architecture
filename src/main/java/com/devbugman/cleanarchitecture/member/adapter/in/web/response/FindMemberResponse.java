package com.devbugman.cleanarchitecture.member.adapter.in.web.response;

/**
 * ํ์ ์กฐํ response
 */
public record FindMemberResponse(
        Long id,
        String nickname,
        String role,
        String status
) {
}
