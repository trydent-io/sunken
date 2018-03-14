package io.sunken.light;

import io.sunken.lang.KwH;

final class LightImpl implements Light {
  private final KwH kwh;

  LightImpl(final KwH kwh) {
    this.kwh = kwh;
  }

  @Override
  public Object get() {
    return null;
  }
}
