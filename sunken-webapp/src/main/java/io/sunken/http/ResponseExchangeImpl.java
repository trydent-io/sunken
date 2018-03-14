package io.sunken.http;

import io.undertow.server.HttpServerExchange;

final class ResponseExchangeImpl implements ResponseExchange {
  private final HttpServerExchange exchange;

  ResponseExchangeImpl(HttpServerExchange exchange) {
    this.exchange = exchange;
  }

  @Override
  public HttpServerExchange get() {
    exchange.setStatusCode(200);
    return null;
  }
}
