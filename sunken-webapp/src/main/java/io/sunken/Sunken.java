package io.sunken;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import org.slf4j.Logger;

import static io.sunken.HttpPath.httpPath;
import static io.vertx.ext.web.Router.router;
import static java.lang.System.currentTimeMillis;
import static org.slf4j.LoggerFactory.getLogger;

final class Sunken extends AbstractVerticle implements Verticle {


  private final HttpFork[] forks;

  Sunken(HttpFork[] forks) {
    this.forks = forks;
  }

  @Override
  public void start() {
  }

}
