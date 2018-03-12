package io.sunken

import io.vertx.core.http.HttpHeaders.CONTENT_TYPE
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import java.util.Properties

class HttpElectricLights(private val properties: Properties) : HttpFork {
  override
  fun handle(it: RoutingContext?) = with(it!!)
  {
    response()
      .setStatusCode(200)
      .putHeader(CONTENT_TYPE, "text/plain")
      .end(properties["elights"].toString())
  }
}

internal class HttpGetRoute(
  private val path: String,
  private val fork: HttpFork) : HttpRoute
{
  override
  fun apply(it: Router): Route = it
    .get(path)
    .handler(fork)
}
