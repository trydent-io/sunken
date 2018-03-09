package io.sunken;

import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public interface HttpFork {
  Route turn(final Router router);
}
