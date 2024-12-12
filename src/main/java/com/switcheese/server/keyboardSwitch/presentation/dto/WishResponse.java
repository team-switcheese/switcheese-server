package com.switcheese.server.keyboardSwitch.presentation.dto;

import com.switcheese.server.keyboardSwitch.domain.model.Wish;

public record WishResponse(Long wishId, Long keyboardSwitchId) {

  public static WishResponse of(Wish wish) {
    return new WishResponse(wish.getId(), wish.getKeyboardSwitch().getId());
  }

}
