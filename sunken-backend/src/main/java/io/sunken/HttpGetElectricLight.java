package io.sunken;

import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

import static io.sunken.ElectricLight.asJson;
import static io.vertx.core.http.HttpHeaders.CONTENT_TYPE;

final class HttpGetElectricLight implements ElectricLight, HttpFork {
  @Override
  public Route turn(Router router) {
    return router.get("/elight").handler(it -> it.response()
      .setStatusCode(200)
      .putHeader(CONTENT_TYPE, "application/json")
      .end(asJson(12, 13, 14).toString()));
  }
}
