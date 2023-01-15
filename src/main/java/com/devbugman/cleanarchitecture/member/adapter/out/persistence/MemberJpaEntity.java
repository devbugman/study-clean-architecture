package com.devbugman.cleanarchitecture.member.adapter.out.persistence;

import com.devbugman.cleanarchitecture.common.BaseTimeEntity;
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
public class MemberJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    public MemberJpaEntity(final Long id, final String nickname, final String password, final Role role, final Status status) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public static MemberJpaEntity newMember(final String nickname, final String password) {
        return new MemberJpaEntity(null, nickname, password, Role.MEMBER, Status.ACTIVATED);
    }

    public void delete() {
        this.status = Status.DEACTIVATED;
    }

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
