package com.switcheese.server.domain.comment;

import com.switcheese.server.domain.member.Member;
import com.switcheese.server.domain.switcheese.Switch;
import com.switcheese.server.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "switch_id", nullable = false)
    private Switch switchEntity;

    private String commentBody;

    private Integer likeCount;

    private Integer dislikeCount;

    private Boolean isDelete;
}
