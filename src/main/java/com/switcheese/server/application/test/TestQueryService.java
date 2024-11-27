package com.switcheese.server.application.test;

import com.switcheese.server.application.test.model.MemberSummary;
import com.switcheese.server.domain.member.Member;
import com.switcheese.server.domain.member.MemberRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestQueryService {
    private MemberRepository memberRepository;

    public TestQueryService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberSummary> test(){
        List<Member> memberList = memberRepository.test();
        return MemberSummary.of(memberList);
    }
}
