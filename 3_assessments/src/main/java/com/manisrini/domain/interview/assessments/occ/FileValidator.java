package com.manisrini.domain.interview.assessments.occ;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

public class FileValidator {

  private FileValidator() {
    // Not required
  }

  public static void isValidFile(String[] filePath) {
    if (filePath.length == 0) {
      throw new ScoreValidationException("Please provide a file to process! Usage: java Application <Absolute File Path>");
    }
    Optional.ofNullable(filePath[0])
        .map(it -> Path.of(it.trim()))
        .filter(Files::isRegularFile)
        .map(Files::isReadable)
        .orElseThrow(() -> new ScoreValidationException("Invalid file:" + filePath[0]));
  }

}
