package com.switcheese.server.keyboardSwitch.presentation.wish;

import com.switcheese.server.keyboardSwitch.application.wish.WishService;
import com.switcheese.server.keyboardSwitch.presentation.dto.WishSwitchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishController {

  private WishService wishService;

  public WishController(WishService wishService) {
    this.wishService = wishService;
  }

  @PostMapping("")
  public ResponseEntity<Void> wishSwitch(@RequestHeader("memberId") Long memberId,
      @ModelAttribute WishSwitchRequest request) {
    wishService.wishSwitch(request, memberId);
    return ResponseEntity.noContent().build();
  }

}
