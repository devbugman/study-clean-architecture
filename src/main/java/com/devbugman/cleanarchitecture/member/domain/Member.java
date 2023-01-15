package com.devbugman.cleanarchitecture.member.domain;

/**
 * Member Domain
 */
public record Member(
        Long id,
        String nickname,
        String password,
        String role,
        String status
) {
    public static Member newMember(final String nickname, final String password) {
        return new Member(null, nickname, password, null, null);
    }
}
