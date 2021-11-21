package com.manisrini.domain;

public enum Gender {
  MALE("Male", "M"),
  FEMALE("Female", "F");

  private final String genderDescription;
  private final String genderCode;

  Gender(String genderDescription, String genderCode) {
    this.genderDescription = genderDescription;
    this.genderCode = genderCode;
  }

  public String getGenderDescription() {
    return genderDescription;
  }

  public String getGenderCode() {
    return genderCode;
  }

  @Override
  public String toString() {
    return genderDescription;
  }
}
