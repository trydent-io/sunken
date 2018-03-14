package io.sunken.http;

import com.google.common.truth.Truth8;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.ServerConnection;
import io.undertow.util.HttpString;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicReference;

import static com.google.common.truth.Truth.assertThat;
import static io.sunken.http.Method.Get;
import static io.undertow.Handlers.routing;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.mock;

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform.class)
class RequestTest {
  private final ServerConnection connection = mock(ServerConnection.class);
  private final HttpServerExchange exchange = new HttpServerExchange(connection);

  @Test
  void shouldHaveMethod() {
    exchange.setRequestMethod(new HttpString("GET"));

    assertThat(Request.from(exchange).is(Get)).isTrue();
  }

  @Test
  void shouldHaveHeader() {
    exchange.getRequestHeaders().put(new HttpString("Content-Type"), "application/json");

    Truth8.assertThat(Request.from(exchange).getHeader("Content-Type")).isPresent();
    Truth8.assertThat(Request.from(exchange).getHeader("Content-Type")).hasValue("application/json");
  }

  @Test
  @Disabled
  void shouldHaveBody() {
    final AtomicReference<byte[]> body = new AtomicReference<>();
    exchange.getRequestReceiver().receiveFullBytes((e, it) -> body.set(it));

    assertThat(Request.from(exchange).asBytes()).isNotNull();
  }
}
