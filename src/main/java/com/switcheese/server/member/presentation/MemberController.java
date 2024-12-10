package com.switcheese.server.member.presentation;

import com.switcheese.server.member.application.MemberService;
import com.switcheese.server.member.presentation.dto.MemberListRequest;
import com.switcheese.server.member.presentation.dto.MemberListResponse;
import com.switcheese.server.member.presentation.dto.MemberModifyRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

  private MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @DeleteMapping("/resign")
  public ResponseEntity<Void> resignMember(@RequestHeader("memberId") Long memberId) {
    memberService.resignMember(memberId);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("")
  public ResponseEntity<Void> modifyMember(@RequestHeader("memberId") Long memberId,
      @RequestBody MemberModifyRequest request) {
    memberService.modifyMember(request, memberId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("")
  public ResponseEntity<Page<MemberListResponse>> memberList(
      @ModelAttribute MemberListRequest request) {
    Page<MemberListResponse> response = memberService.memberList(
        request.toPageableRequest());
    return ResponseEntity.ok(response);
  }

}
