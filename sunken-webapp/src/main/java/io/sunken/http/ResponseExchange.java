package io.sunken.http;

import io.sunken.lang.Projection;
import io.undertow.server.HttpServerExchange;

public interface ResponseExchange extends Projection<HttpServerExchange> {
  static ResponseExchange of(final HttpServerExchange exchange) {
    return new ResponseExchangeImpl(new HttpServerExchange(null));
  }
}
