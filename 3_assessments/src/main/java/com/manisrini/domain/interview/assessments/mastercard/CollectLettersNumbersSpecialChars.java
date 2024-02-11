package com.manisrini.domain.interview.assessments.mastercard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectLettersNumbersSpecialChars {

  public static void main(String[] args) throws IOException {

    System.out.println("To check where is the default Paths.get is looking for a file:" + System.getProperty("user.dir"));

    List<String> listOfLinesInFile = Files.readAllLines(Paths.get(
        "3_assessments/src/main/java/com/manisrini/domain/interview/assessments/mastercard/google.html"));

    List<Character> lettersCollection = listOfLinesInFile.stream()
        .flatMap(it -> it.codePoints().mapToObj(c -> (char) c))
        .filter(Character::isLetter)
        .collect(Collectors.toList());

    Collections.reverse(lettersCollection);

    List<Character> numbersCollection = listOfLinesInFile.stream()
        .flatMap(it -> it.codePoints().mapToObj(c -> (char) c))
        .filter(Character::isDigit)
        .filter(it -> it % 2 != 0)
        .collect(Collectors.toList());

    List<Character> specialCharactersCollection = listOfLinesInFile.stream()
        .flatMap(it -> it.codePoints().mapToObj(c -> (char) c))
        .filter(it -> !Character.isWhitespace(it))
        .filter(it -> !Character.isLetterOrDigit(it))
        .collect(Collectors.toList());


    System.out.println("lettersCollection:" + lettersCollection);
    System.out.println("numbersCollection:" + numbersCollection);
    System.out.println("specialCharactersCollection:" + specialCharactersCollection);

  }
}
