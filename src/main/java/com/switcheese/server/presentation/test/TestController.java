package com.switcheese.server.presentation.test;

import com.switcheese.server.application.test.TestQueryService;
import com.switcheese.server.application.test.model.MemberSummary;
import com.switcheese.server.presentation.test.model.MemberResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private TestQueryService testQueryService;

    public TestController(TestQueryService testQueryService) {
        this.testQueryService = testQueryService;
    }

    @GetMapping("/test")
    public List<MemberResponse> test(){
        List<MemberSummary> memberSummaries = testQueryService.test();
        return MemberResponse.of(memberSummaries);
    }
}
