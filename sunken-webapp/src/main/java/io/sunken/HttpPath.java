package io.sunken;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;

public interface HttpPath extends Handler<HttpServerRequest> {
  static HttpPath httpPath(final Router router, final HttpFork... forks) {
    return new HttpPathImpl(router, forks);
  }

  HttpPath enter();
}
