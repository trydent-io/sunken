package io.sunken.http;

import io.undertow.server.HttpServerExchange;

import java.util.Optional;

public interface Request {
  static Request from(final HttpServerExchange exchange) {
    return new RequestImpl(exchange);
  }

  boolean is(final Method method);
  Optional<String> getHeader(final String entry);

  byte[] asBytes();
}
