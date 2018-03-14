package io.sunken.http;

import io.undertow.server.HttpServerExchange;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNullElse;

final class RequestImpl implements Request {
  private final HttpServerExchange exchange;

  RequestImpl(final HttpServerExchange exchange) {
    this.exchange = exchange;
  }

  @Override
  public final boolean is(final Method method) {
    return nonNull(method) && method.name()
      .toLowerCase()
      .equals(exchange
        .getRequestMethod()
        .toString()
        .toLowerCase()
      );
  }

  @Override
  public final Optional<String> getHeader(final String entry) {
    return Optional.ofNullable(entry)
      .filter(it -> exchange.getRequestHeaders().contains(entry))
      .map(it -> exchange.getRequestHeaders().get(entry))
      .map(it -> it.getFirst());
  }

  @Override
  public final byte[] asBytes() {
    final AtomicReference<byte[]> bytes = new AtomicReference<>();
    exchange.getRequestReceiver().receiveFullBytes((e, it) -> bytes.set(requireNonNullElse(it, new byte[0])));
    return bytes.get();
  }
}
