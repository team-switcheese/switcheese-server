package com.switcheese.server.common.exception;

public class KeyBoardNotFoundException extends BusinessException {

  private final SampleErrorCode code;

  public KeyBoardNotFoundException(SampleErrorCode code, Object... args) {
    super(code.getStatus(), code.toString(), code.getMessage(), args);
    this.code = code;
  }

}
