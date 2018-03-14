package io.sunken;

public final class SunkenException extends RuntimeException {
  public SunkenException() {
    super();
  }

  public SunkenException(String message) {
    super(message);
  }

  public SunkenException(String message, Throwable cause) {
    super(message, cause);
  }

  public SunkenException(Throwable cause) {
    super(cause);
  }

  protected SunkenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
