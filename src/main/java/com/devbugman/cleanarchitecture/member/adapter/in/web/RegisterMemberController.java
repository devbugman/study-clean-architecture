package com.devbugman.cleanarchitecture.member.adapter.in.web;

import com.devbugman.cleanarchitecture.member.adapter.in.web.request.RegisterMemberRequest;
import com.devbugman.cleanarchitecture.member.application.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterMemberController {
    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping("/api/members")
    public Long registerMember(@RequestBody RegisterMemberRequest request) {
        return registerMemberUseCase.registerMember(
                new RegisterMemberUseCase.RegisterMemberCommend(request.nickname(), request.password(), request.checkPassword()));
    }
}
