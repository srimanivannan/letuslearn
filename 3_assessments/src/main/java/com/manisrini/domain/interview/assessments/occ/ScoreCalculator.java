package com.manisrini.domain.interview.assessments.occ;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ScoreCalculator {

  int calculateScore(Path filepath);

  static ScoreCalculator defaultScoreCalculator(Path filePath) {
    return calculator -> {
      try {
        List<String> linesList = Files.readAllLines(filePath, Charset.defaultCharset());
        List<String> sortedNamesList =
            linesList.parallelStream().flatMap(it -> Arrays.stream(it.split(",")))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return IntStream.range(0, sortedNamesList.size()).parallel()
            .mapToObj(index -> computeScore(sortedNamesList.get(index), index + 1)).mapToInt(Integer::intValue).sum();
      } catch (IOException e) {
        e.printStackTrace();
        return 0;
      }
    };
  }

  private static int computeScore(String nameOfThePerson, int positionOfThePerson) {
    return nameOfThePerson
        .codePoints()
        .mapToObj(c -> (char) c)
        .filter(Character::isAlphabetic)
        .map(Alphabet::getScore)
        .mapToInt(Integer::intValue).sum() * positionOfThePerson;
  }
}
