package io.sunken;

import io.undertow.Undertow;

import static io.undertow.util.Headers.CONTENT_TYPE;

public interface Main {
  static void main(String... args) {
    final Undertow server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(exchange -> {
        exchange.getResponseHeaders().put(CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
      }).build();
    server.start();
  }
}
