package com.switcheese.server.domain.switcheese;

import com.switcheese.server.domain.common.BaseEntity;
import com.switcheese.server.domain.member.Member;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "switch_like")
public class SwitchLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long switchLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "switch_id", nullable = false)
    private Switch switchEntity;
}
