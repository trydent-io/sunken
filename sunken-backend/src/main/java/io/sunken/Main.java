package io.sunken;

public interface Main {
  static Sunken sunken(Fork... forks) { return new Sunken(forks); }

  static void main(String... args) {
    sunken().start();
  }
}
