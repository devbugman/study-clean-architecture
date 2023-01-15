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
}
