package com.switcheese.server.member.presentation.dto;

public record MemberModifyRequest(String nickname) {
  //TODO 닉네임 검증 로직
  //TODO 멤버에 수정할 수 있는 필드들 추가
}
