package io.sunken;

import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public interface Fork {
  default Route turn(final Router router) {
    return turn(router, "/");
  }
  Route turn(final Router router, final String path);
}
