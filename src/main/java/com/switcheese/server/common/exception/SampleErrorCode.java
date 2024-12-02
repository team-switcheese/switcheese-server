package com.switcheese.server.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SampleErrorCode {
  NOT_FOUND_USER(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다. : [%s]");

  private final HttpStatus status;
  private final String message;
  
  SampleErrorCode(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }
}
