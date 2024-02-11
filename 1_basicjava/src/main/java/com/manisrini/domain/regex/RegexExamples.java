package com.manisrini.domain.regex;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegexExamples {

  public static void main(String[] args) {
    extract("\\d", "string1234AAB!@#$%Bmore567)</&*>?(string890"); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
    extract("[a-zA-Z]", "string1234AAB!@#$%Bmore567)</&*>?(string890"); //[s, t, r, i, n, g, A, A, B, B, m, o, r, e, s, t, r, i, n, g]
    extract(".", "string1234AAB!@#$%Bmore567)</&*>?(string890"); //[s, t, r, i, n, g, 1, 2, 3, 4, A, A, B, !, @, #, $, %, B, m, o, r, e, 5, 6, 7, ), <, /, &, *, >, ?, (, s, t, r, i, n, g, 8, 9, 0]
    // Just add `+` to above regex. it will find all until it doesn't match the group
    extract("\\d+", "string1234AAB!@#$%Bmore567)</&*>?(string890"); //[1234, 567, 890]
    extract("[a-zA-Z]+", "string,1234AAB!@#$%Bmore567)</&*>?(string890"); //[string, AAB, Bmore, string]

    extract("[^a-zA-Z0-9]", "string1234AAB!@#$%Bmore567)</&*>?(string890"); //[!, @, #, $, %, ), <, /, &, *, >, ?, (]
    extract("\\d", "if No numbers on d"); // [] No NullPointerException o m.results() below
    extract("\\w", "This is a word"); // [T, h, i, s, i, s, a, w, o, r, d] because no `+` in there after \\w
    extract("\\w+", "This is a word"); //[This, is, a, word]
  }

  private static void extract(String regexPattern, String inputString) {
    Pattern p = Pattern.compile(regexPattern);
    Matcher m = p.matcher (inputString);
    List<String> collect = m.results().map(MatchResult::group).collect(Collectors.toList());
    System.out.println(collect);
  }

}
