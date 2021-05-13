package com.manisrini.domain.interview.assessments.occ;

import java.nio.file.Path;

public class Application {

  public static void main(String[] args) {
    ScoreCalculator scoreCalculator = new DefaultScoreCalculator();
    //String file = "/Users/mani/workshop/letuslearn/3_assessments/src/main/java/com/manisrini/domain/interview/assessments/occ/names.txt";
    //String file = "/Users/mani/workshop/letuslearn/3_assessments/src/main/java/com/manisrini/domain/interview/assessments/occ/";
    //String file = " 9   ";

    try {
      FileValidator.isValidFile(args);
      System.out.println(scoreCalculator.calculateScore(Path.of(args[0])));
    } catch (ScoreValidationException exception) {
      System.err.printf("ERROR! %s:%n", exception.getMessage());
    } catch (Exception exception) {
      System.err.printf("Internal ERROR! %s%n", exception.getMessage());
    }
  }
}
