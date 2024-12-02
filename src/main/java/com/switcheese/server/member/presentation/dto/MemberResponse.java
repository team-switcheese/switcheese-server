package com.switcheese.server.member.presentation.dto;


import com.switcheese.server.member.domain.model.Member;
import java.util.List;
import java.util.stream.Collectors;

public record MemberResponse(Long memberId, String userName) {

  public static List<MemberResponse> of(List<Member> memberList) {
    return memberList.stream()
        .map(summary -> new MemberResponse(summary.getId(), summary.getUsername()))
        .collect(Collectors.toList());
  }

}
