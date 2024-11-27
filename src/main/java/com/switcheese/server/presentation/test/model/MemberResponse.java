package com.switcheese.server.presentation.test.model;

import com.switcheese.server.application.test.model.MemberSummary;

import java.util.List;
import java.util.stream.Collectors;

public record MemberResponse(Long memberId, String userName) {
    public static List<MemberResponse> of(List<MemberSummary> summaries){
        return summaries.stream()
                .map(summary -> new MemberResponse(summary.memberId(), summary.userName()))
                .collect(Collectors.toList());
    }
}
