package com.switcheese.server.member.application;

import com.switcheese.server.member.domain.MemberRepository;
import com.switcheese.server.member.domain.model.Member;
import com.switcheese.server.member.presentation.dto.MemberResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestQueryService {

  private MemberRepository memberRepository;

  public TestQueryService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public List<MemberResponse> test() {
    List<Member> memberList = memberRepository.test();
    return MemberResponse.of(memberList);
  }

}
