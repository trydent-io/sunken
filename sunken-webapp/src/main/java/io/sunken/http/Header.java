package io.sunken.http;

import static java.util.Objects.requireNonNull;

public final class Header {
  private final String entry;
  private final String value;

  private Header(final String entry, final String value) {
    this.entry = entry;
    this.value = value;
  }

  public final String entry() { return this.entry; }
  public final String value() { return this.value; }

  public static Header of(final String entry, final String value) {
    return new Header(
      requireNonNull(entry, "Entry can not be null"),
      requireNonNull(value, "Value can not be null")
    );
  }
}
