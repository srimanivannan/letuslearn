package com.manisrini.domain.java8.optional;

import java.util.Optional;

public class OptionalMath {

  public static Optional<Double> invert(Double aDouble) {
    return aDouble != 0d ? Optional.of(1d/aDouble):Optional.empty();
  }

  public static Optional<Double> squareRoot(Double aDouble) {
    return aDouble > 0d ? Optional.of(Math.sqrt(aDouble)):Optional.empty();
  }

}
