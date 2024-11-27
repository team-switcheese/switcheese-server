package com.switcheese.server.application.test.model;

import com.switcheese.server.domain.member.Member;

import java.util.List;
import java.util.stream.Collectors;

public record MemberSummary(Long memberId, String userName) {
    public static List<MemberSummary> of(List<Member> memberList) {
        return memberList.stream()
                .map(member -> new MemberSummary(member.getMemberId(), member.getUserName()))
                .collect(Collectors.toList());
    }
}
