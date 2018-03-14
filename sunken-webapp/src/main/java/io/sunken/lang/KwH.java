package io.sunken.lang;

import java.util.Optional;
import java.util.function.Supplier;

public final class KwH implements Supplier<Integer> {
  private final int value;

  private KwH(final int value) {
    this.value = value;
  }

  @Override
  public Integer get() {
    return this.value;
  }

  public static Optional<KwH> of(final int kwh) {
    return Optional.of(kwh)
      .filter(it -> it >= 2_048 && it <= 65_536)
      .map(KwH::new);
  }
}
