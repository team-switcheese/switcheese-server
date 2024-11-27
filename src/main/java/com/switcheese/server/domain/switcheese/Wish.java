package com.switcheese.server.domain.switcheese;

import com.switcheese.server.domain.common.BaseEntity;
import com.switcheese.server.domain.member.Member;
import com.switcheese.server.domain.switcheese.Switch;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "wish")
public class Wish extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "switch_id", nullable = false)
    private Switch switchEntity;

    private Boolean isDelete;
}

