package com.switcheese.server.keyboardSwitch.application.wish;

import static com.switcheese.server.common.exception.SampleErrorCode.NOT_FOUND_KEYBOARD_SWITCH;
import static com.switcheese.server.common.exception.SampleErrorCode.NOT_FOUND_USER;

import com.switcheese.server.common.exception.KeyBoardNotFoundException;
import com.switcheese.server.common.exception.NoSuchMemberException;
import com.switcheese.server.keyboardSwitch.domain.KeyboardSwitchRepository;
import com.switcheese.server.keyboardSwitch.domain.WishRepository;
import com.switcheese.server.keyboardSwitch.domain.model.KeyboardSwitch;
import com.switcheese.server.keyboardSwitch.domain.model.Wish;
import com.switcheese.server.keyboardSwitch.presentation.dto.WishResponse;
import com.switcheese.server.keyboardSwitch.presentation.dto.WishSwitchRequest;
import com.switcheese.server.member.domain.MemberRepository;
import com.switcheese.server.member.domain.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WishService {

  private WishRepository wishRepository;
  private MemberRepository memberRepository;
  private KeyboardSwitchRepository keyboardSwitchRepository;

  public WishService(WishRepository wishRepository, MemberRepository memberRepository,
      KeyboardSwitchRepository keyboardSwitchRepository) {
    this.wishRepository = wishRepository;
    this.memberRepository = memberRepository;
    this.keyboardSwitchRepository = keyboardSwitchRepository;
  }

  @Transactional
  public void wishSwitch(WishSwitchRequest request, Long memberId) {
    Member member = memberRepository.findById(memberId)
        .orElseThrow(() -> new NoSuchMemberException(NOT_FOUND_USER));
    KeyboardSwitch keyboardSwitch = keyboardSwitchRepository.findByIdAndIsDeleteFalse(
            request.switchId())
        .orElseThrow(() -> new KeyBoardNotFoundException(NOT_FOUND_KEYBOARD_SWITCH));

    wishRepository.findByMemberAndKeyboardSwitch(member,
        keyboardSwitch).ifPresentOrElse(
        wish -> wish.turnActive(request.active()),
        () -> wishRepository.save(new Wish(member, keyboardSwitch, request.active()))
    );
  }

  public Page<WishResponse> wishList(Long memberId, Pageable request) {
    Member member = memberRepository.findById(memberId)
        .orElseThrow(() -> new NoSuchMemberException(NOT_FOUND_USER));
    return wishRepository.findByMemberAndIsActiveTrue(member, request).map(WishResponse::of);
  }

}
