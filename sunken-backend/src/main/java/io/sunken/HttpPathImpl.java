package io.sunken;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;

final class HttpPathImpl implements HttpPath {
  private final Router router;
  private final HttpFork[] forks;

  HttpPathImpl(final Router router, final HttpFork[] forks) {
    this.router = router;
    this.forks = forks;
  }

  @Override
  public void handle(HttpServerRequest request) {
    this.router.accept(request);
  }

  @Override
  public HttpPath enter() {
    for (HttpFork fork : this.forks) fork.turn(this.router);
    return this;
  }
}
