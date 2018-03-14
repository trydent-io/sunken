package io.sunken.http;

import io.undertow.server.HttpServerExchange;

import static java.util.Objects.requireNonNull;

public interface Response {
  static Response of(final StatusCode code) {
    return new ResponseImpl(requireNonNull(code, "StatusCode can not be null."));
  }

  boolean is(final StatusCode code);
  boolean has(final String header);

  Response header(final String entry, final String value);

  <P extends ResponseExchange> HttpServerExchange apply(final P projection);
}
