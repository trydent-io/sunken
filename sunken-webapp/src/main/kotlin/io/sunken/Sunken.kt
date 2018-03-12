package io.sunken

import io.sunken.HttpPath.httpPath
import io.vertx.core.AbstractVerticle
import io.vertx.core.Verticle
import io.vertx.ext.web.Router.router
import org.slf4j.LoggerFactory.getLogger
import java.lang.System.currentTimeMillis

class Sunken(vararg val forks: HttpFork) : AbstractVerticle(), Verticle {
  private val log = getLogger(Sunken::class.java)

  override fun start() {
    val startedMills = currentTimeMillis()
    vertx
      .createHttpServer()
      .requestHandler(
        httpPath(router(vertx), *forks).enter()
      )
      .listen(8080)
    log.info("Sunken has been started in {} ms.", currentTimeMillis() - startedMills)
  }
}

fun main(args: Array<String>) {
  Sunken().start()
}
