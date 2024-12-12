package com.switcheese.server.member.presentation.dto;

import com.switcheese.server.member.domain.model.Member;

public record MemberListResponse(String username, String nickname, String role, Boolean isDelete) {

  public static MemberListResponse of(Member member) {
    return new MemberListResponse(
        member.getUsername(),
        member.getNickname(),
        member.getRole(),
        member.getIsDelete()
    );
  }

}
