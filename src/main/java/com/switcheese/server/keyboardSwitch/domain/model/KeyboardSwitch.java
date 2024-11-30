package com.switcheese.server.keyboardSwitch.domain.model;

import com.switcheese.server.config.BaseEntity;
import com.switcheese.server.member.domain.model.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "keyboard_switch")
public class KeyboardSwitch extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "keyboard_switch_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  @Column(name = "keyboard_switch_name")
  private String switchName;

  private String company;

  private Long forceVal;

  private String switchType;

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
