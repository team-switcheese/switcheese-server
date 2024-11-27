package com.switcheese.server.domain.switcheese;

import com.switcheese.server.domain.common.BaseEntity;
import com.switcheese.server.domain.member.Member;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "switch")
public class Switch extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long switchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private String switchName;

    private String company;

    private Long forceVal;

    private String type;

    private Boolean isSilent;

    private Long likeCount;

    private Long commentCount;

    private Boolean isDelete;

    private String img;

    private Long spring;

    private Long stem;

    private Long travel;

    private String material;

    private Long inputPoint;

    private Boolean preLubed;

    private Long mountPin;
}