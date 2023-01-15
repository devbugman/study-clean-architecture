package com.devbugman.cleanarchitecture.member.adapter.out.persistence;

import com.devbugman.cleanarchitecture.member.application.port.out.ExitstNicknamePort;
import com.devbugman.cleanarchitecture.member.application.port.out.MemberPort;
import com.devbugman.cleanarchitecture.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
        jpaMemberRepository.findById(id)
                .orElseThrow()
                .delete();
    }

    @Override
    public void update(final Long id, final Member member) {

    }

    @Override
    public List<Member> read() {
        return jpaMemberRepository.findAll().stream()
                .map(it -> new Member(
                        it.getId(),
                        it.getNickname(),
                        it.getPassword(),
                        it.getRole().name(),
                        it.getStatus().name())
                )
                .toList();
    }

    @Override
    public Member readOne(final Long id) {
        // TODO Exception
        return jpaMemberRepository.findById(id)
                .map(it -> new Member(
                        it.getId(),
                        it.getNickname(),
                        it.getPassword(),
                        it.getRole().name(),
                        it.getStatus().name()
                ))
                .orElseThrow();
    }

    @Override
    public Member findByNickname(final String nickname) {
        // TODO Exception
        return jpaMemberRepository.findByNickname(nickname)
                .map(it -> new Member(
                        it.getId(),
                        it.getNickname(),
                        it.getPassword(),
                        it.getRole().name(),
                        it.getStatus().name()
                )).orElseThrow();
    }
}
