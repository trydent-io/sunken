package io.sunken.http;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderValues;

import java.util.Optional;

public interface Request {
  static Request from(final HttpServerExchange exchange) {
    return new RequestImpl(exchange);
  }

  boolean is(final Method method);
  Optional<HeaderValues> getHeader(final String entry);

  byte[] asBytes();
}
