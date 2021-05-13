package com.manisrini.domain.interview.assessments.occ;

public enum Alphabet {
  A('A', 1),
  B('B', 2),
  C('C', 3),
  D('D', 4),
  E('E', 5),
  F('F', 6),
  G('G', 7),
  H('H', 8),
  I('I', 9),
  J('J', 10),
  K('K', 11),
  L('L', 12),
  M('M', 13),
  N('N', 14),
  O('O', 15),
  P('P', 16),
  Q('Q', 17),
  R('R', 18),
  S('S', 19),
  T('T', 20),
  U('U', 21),
  V('V', 22),
  W('W', 23),
  X('X', 24),
  Y('Y', 25),
  Z('Z', 26);

  private final Character name;
  private final Integer value;

  Alphabet(Character name, Integer value) {
    this.name = name;
    this.value = value;
  }

  public Character getName() {
    return name;
  }

  public Integer getValue() {
    return value;
  }

  public static Integer getScore(Character character) {
    return Alphabet.valueOf(String.valueOf(character).toUpperCase()).getValue();
  }

}
