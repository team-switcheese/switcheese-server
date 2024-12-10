package com.switcheese.server.member.presentation.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public record MemberListRequest(Integer page, Integer size) {

  public Pageable toPageableRequest() {
    return PageRequest.of(page, size);
  }

}
