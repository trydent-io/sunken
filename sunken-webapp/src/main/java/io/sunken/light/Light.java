package io.sunken.light;

import io.sunken.lang.KwH;
import io.sunken.lang.Projection;

public interface Light extends Projection {
  static Light plain(final KwH kwh) {
    return new LightImpl(kwh);
  }
}
