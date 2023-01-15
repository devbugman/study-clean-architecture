package com.devbugman.cleanarchitecture.member.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Member Entity
 */
@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    enum Role {
        ADMIN("관리자"), MEMBER("회원");
        private final String name;

    }

    @Getter
    @RequiredArgsConstructor
    enum Status {
        ACTIVATED("활성화"), DEACTIVATED("비활성화");

        private final String name;
    }
}
