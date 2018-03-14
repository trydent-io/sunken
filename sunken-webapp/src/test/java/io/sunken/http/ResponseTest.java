package io.sunken.http;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static com.google.common.truth.Truth.assertThat;
import static io.sunken.http.StatusCode.Ok;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform.class)
class ResponseTest {
  @Test
  void shouldHasStatus200() {
    assertThat(Response.of(Ok).is(Ok)).isTrue();
  }

  @Test
  void shouldBreakWithNull() {
    assertThrows(NullPointerException.class, () -> Response.of(null));
  }

  @Test
  void shouldHasHeader() {
    assertThat(Response.of(Ok).header("Content-Type", "application/json").has("Content-Type")).isTrue();
  }
}
