package io.sunken;

import com.google.gson.Gson;

final class JsonElectricLight implements ElectricLight {
  private final int amount1;
  private final int amount2;
  private final int amount3;

  JsonElectricLight(int amount1, int amount2, int amount3) {
    this.amount1 = amount1;
    this.amount2 = amount2;
    this.amount3 = amount3;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
