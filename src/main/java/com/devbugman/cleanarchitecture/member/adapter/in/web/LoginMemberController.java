package com.devbugman.cleanarchitecture.member.adapter.in.web;

import com.devbugman.cleanarchitecture.member.adapter.in.web.request.LoginMemberRequest;
import com.devbugman.cleanarchitecture.member.application.port.in.LoginMemberUseCase;
import com.devbugman.cleanarchitecture.member.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginMemberController {
    private LoginMemberUseCase loginMemberUseCase;

    @PostMapping("/api/members/login")
    public void login(@RequestBody final LoginMemberRequest request, final HttpServletRequest httpServletRequest) {
        final var loginMember = loginMemberUseCase.login(request.nickname(), request.password());
        final HttpSession session = httpServletRequest.getSession();
        session.setAttribute("memberId", loginMember.id());
    }
}
