package com.switcheese.server.member.application;

import static com.switcheese.server.common.exception.SampleErrorCode.NOT_FOUND_USER;

import com.switcheese.server.common.exception.NoSuchMemberException;
import com.switcheese.server.member.domain.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Transactional
  public void resignMember(Long memberId) {
    memberRepository.findById(memberId)
        .orElseThrow(() -> new NoSuchMemberException(NOT_FOUND_USER))
        .resign();
    //TODO 소셜로그인 탈퇴 로직 추가
  }

}
