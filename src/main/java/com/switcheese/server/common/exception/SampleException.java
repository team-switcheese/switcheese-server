package com.switcheese.server.common.exception;

public class SampleException extends BusinessException {

  private final SampleErrorCode code;

  public SampleException(SampleErrorCode code, Object... args) {
    super(code.getStatus(), code.toString(), code.getMessage(), args);
    this.code = code;
  }

  /*
   * 사용법
   * throw new SampleException(SampleErrorCode.NOT_FOUND_USER, 1);
   * */

}
