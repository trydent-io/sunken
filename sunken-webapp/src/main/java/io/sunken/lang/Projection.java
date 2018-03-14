package io.sunken.lang;

@FunctionalInterface
public interface Projection<R> {
  R get();
}
