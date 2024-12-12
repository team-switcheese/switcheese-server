package com.switcheese.server.member.domain.model;

import com.switcheese.server.config.BaseEntity;
import com.switcheese.server.member.presentation.dto.MemberModifyRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  private String username;

  private String password;

  private String nickname;

  private String role;

  private Boolean isDelete;

  public void resign() {
    this.isDelete = true;
  }

  public void modify(MemberModifyRequest request) {
    this.nickname = request.nickname();
  }

}
