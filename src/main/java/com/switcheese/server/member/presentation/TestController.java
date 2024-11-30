package com.switcheese.server.member.presentation;

import com.switcheese.server.member.application.TestQueryService;
import com.switcheese.server.member.presentation.dto.MemberResponse;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private TestQueryService testQueryService;

  public TestController(TestQueryService testQueryService) {
    this.testQueryService = testQueryService;
  }

  @GetMapping("/test")
  public List<MemberResponse> test() {
    return testQueryService.test();
  }

}
