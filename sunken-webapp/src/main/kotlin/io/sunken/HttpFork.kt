package io.sunken

import io.vertx.core.Handler
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.HttpMethod.DELETE
import io.vertx.core.http.HttpMethod.GET
import io.vertx.core.http.HttpMethod.PATCH
import io.vertx.core.http.HttpMethod.POST
import io.vertx.core.http.HttpMethod.PUT
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import java.util.function.Function

interface HttpFork : Handler<RoutingContext>
interface HttpRoute : Function<Router, Route>

abstract class DefaultHttpRoute(
  private val method: HttpMethod,
  private val path: String,
  private val fork: HttpFork
) : HttpRoute {
  final override fun apply(it: Router) = it.route(method, path).handler(fork)
}

internal class HttpRouteImpl(method: HttpMethod, path: String, fork: HttpFork) : DefaultHttpRoute(method, path, fork), HttpRoute

internal class HttpRouteGet(path: String, fork: HttpFork) : DefaultHttpRoute(GET, path, fork), HttpRoute
internal class HttpRoutePatch(path: String, fork: HttpFork) : DefaultHttpRoute(PATCH, path, fork), HttpRoute
internal class HttpRoutePost(path: String, fork: HttpFork) : DefaultHttpRoute(POST, path, fork), HttpRoute
internal class HttpRoutePut(path: String, fork: HttpFork) : DefaultHttpRoute(PUT, path, fork), HttpRoute
internal class HttpRouteDelete(path: String, fork: HttpFork) : DefaultHttpRoute(DELETE, path, fork), HttpRoute

//fun get(path: String, fork: HttpFork): HttpRoute = HttpRouteGet(path, fork)
fun post(path: String, fork: HttpFork): HttpRoute = HttpRoutePost(path, fork)
fun put(path: String, fork: HttpFork): HttpRoute = HttpRoutePut(path, fork)
fun patch(path: String, fork: HttpFork): HttpRoute = HttpRoutePatch(path, fork)
fun delete(path: String, fork: HttpFork): HttpRoute = HttpRouteDelete(path, fork)
fun use(httpMethod: HttpMethod, path: String, fork: HttpFork): HttpRoute = HttpRouteImpl(httpMethod, path, fork)

//fun use(path: String, vararg forks: HttpFork): HttpRoute = get(path, forks[0])

class Use(private val path: String, private val uses: Array<Use>) {
  fun get(fork: HttpFork) = get(this.path, fork)
  fun get(path: String, fork: HttpFork):HttpRoute = HttpRouteGet(path, fork)
}

fun use(path: String): Use = Use(path, [])

/*
use("/api")
  .get

use("/api",
  get { "nothing to show" }
  use("/elights",
    get(it -> ["lights"])
    get("/{id}", it -> "light")
    post(it -> "done")
  )
  post("/aqua", it -> "done")
 */
