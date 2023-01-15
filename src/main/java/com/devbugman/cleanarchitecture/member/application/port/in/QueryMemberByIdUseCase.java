package com.devbugman.cleanarchitecture.member.application.port.in;

import com.devbugman.cleanarchitecture.member.domain.Member;

public interface QueryMemberByIdUseCase {
    Member queryMemberById(Query query);

    record Query(
            Long id
    ) {
    }
}
