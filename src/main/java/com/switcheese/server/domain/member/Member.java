package com.switcheese.server.domain.member;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String userName;

    private String password;

    private String nickname;

    private String role;

    private Boolean isDelete;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
