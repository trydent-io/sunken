package io.sunken;

import static io.vertx.core.Vertx.vertx;

public interface Main {
  static Sunken sunken(HttpFork... forks) { return new Sunken(forks); }

  static void main(String... args) {
    vertx().deployVerticle(
      sunken(
        new HttpGetRoute()
      )
    );
  }
}
