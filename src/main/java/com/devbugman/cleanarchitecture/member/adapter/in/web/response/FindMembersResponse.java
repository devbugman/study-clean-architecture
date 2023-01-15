package com.devbugman.cleanarchitecture.member.adapter.in.web.response;

import java.util.List;

/**
 * 회원 전체 조회 응답
 */
public class FindMembersResponse {
    private int size;
    private List<FindMemberResponse> memberResponses;

    public FindMembersResponse(final int size, final List<FindMemberResponse> memberResponses) {
        this.size = size;
        this.memberResponses = memberResponses;
    }

    public int getSize() {
        return size;
    }

    public List<FindMemberResponse> getMemberResponses() {
        return memberResponses;
    }
}
