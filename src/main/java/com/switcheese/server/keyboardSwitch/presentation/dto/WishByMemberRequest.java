package com.switcheese.server.keyboardSwitch.presentation.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public record WishByMemberRequest(Integer page, Integer size) {

  public Pageable toPageableRequest() {
    return PageRequest.of(page, size);
  }

}
