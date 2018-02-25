package io.sunken;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import io.vertx.ext.web.Router;

import static io.vertx.ext.web.Router.router;

final class Sunken extends AbstractVerticle implements Verticle {
  private final Fork[] forks;

  Sunken(Fork[] forks) {
    this.forks = forks;
  }

  @Override
  public void start() {
    final Router router = router(vertx);

    for (Fork fork : forks) fork.turn(router);

    vertx
      .createHttpServer()
      .requestHandler(router::accept)
      .listen(8080);
  }
}
