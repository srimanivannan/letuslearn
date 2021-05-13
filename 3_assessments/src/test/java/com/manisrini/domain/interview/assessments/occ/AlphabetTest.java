package com.manisrini.domain.interview.assessments.occ;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlphabetTest {

  @Test
  public void ensureValue() {
    Assertions.assertThat(Alphabet.getScore('L')).isEqualTo(12);
  }

}
