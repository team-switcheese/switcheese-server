package com.switcheese.server.common.exception;

public class NoSuchMemberException extends BusinessException {

  private final SampleErrorCode code;

  public NoSuchMemberException(SampleErrorCode code, Object... args) {
    super(code.getStatus(), code.toString(), code.getMessage(), args);
    this.code = code;
  }

}
