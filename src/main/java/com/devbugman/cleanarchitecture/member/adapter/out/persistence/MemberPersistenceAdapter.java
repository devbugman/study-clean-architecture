package com.devbugman.cleanarchitecture.member.adapter.out.persistence;

import com.devbugman.cleanarchitecture.member.application.port.out.ExitstNicknamePort;
import com.devbugman.cleanarchitecture.member.application.port.out.MemberPort;
import com.devbugman.cleanarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements MemberPort, ExitstNicknamePort {

    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public Long save(final Member member) {
        final var saveMember = jpaMemberRepository.save(
                MemberJpaEntity.newMember(member.nickname(), member.password())
        );
        return saveMember.getId();
    }

    @Override
    public boolean existNickname(final String nickname) {
        return jpaMemberRepository.findByNickname(nickname).isPresent();
    }

    @Override
    public void delete(final Long id) {
    }

    @Override
    public void update(final Long id, final Member member) {

    }

    @Override
    public Member readOne(final Long id) {
        return null;
    }

    @Override
    public Member findByNickname(final String nickname) {
        // TODO Exception
        final var findMember = jpaMemberRepository.findByNickname(nickname).orElseThrow();
        return new Member(
                findMember.getId(),
                findMember.getNickname(),
                findMember.getPassword(),
                findMember.getRole().name(),
                findMember.getStatus().name()
        );
    }
}
