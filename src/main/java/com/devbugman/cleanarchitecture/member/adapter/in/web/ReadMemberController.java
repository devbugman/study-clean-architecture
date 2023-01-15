package com.devbugman.cleanarchitecture.member.adapter.in.web;

import com.devbugman.cleanarchitecture.member.adapter.in.web.response.FindMemberResponse;
import com.devbugman.cleanarchitecture.member.adapter.in.web.response.FindMembersResponse;
import com.devbugman.cleanarchitecture.member.application.port.in.FindMembersUseCase;
import com.devbugman.cleanarchitecture.member.application.port.in.QueryMemberByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 회원 조회 API
 */
@RestController
@RequiredArgsConstructor
public class ReadMemberController {
    private final QueryMemberByIdUseCase queryMemberByIdUseCase;
    private final FindMembersUseCase findMembersUseCase;

    @GetMapping("/api/members/{id}")
    public FindMemberResponse queryMemberById(@PathVariable Long id) {
        final var response = queryMemberByIdUseCase.queryMemberById(new QueryMemberByIdUseCase.Query(id));
        return new FindMemberResponse(response.id(), response.nickname(), response.role(), response.status());
    }

    @GetMapping("/api/members")
    public FindMembersResponse getMembers() {
        final var members = findMembersUseCase.findMembers();
        final var response = members.stream()
                .map(it ->
                        new FindMemberResponse(it.id(), it.nickname(), it.role(), it.status()))
                .toList();
        return new FindMembersResponse(response.size(), response);
    }
}
