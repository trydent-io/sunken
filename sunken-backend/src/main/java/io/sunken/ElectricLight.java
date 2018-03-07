package io.sunken;

public interface ElectricLight {
  static ElectricLight asJson(final int amount1, final int amount2, final int amount3) {
    return new JsonElectricLight(amount1, amount2, amount3);
  }
}
