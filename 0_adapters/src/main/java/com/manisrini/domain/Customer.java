package com.manisrini.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Builder
public class Customer {

  private String userId;
  private String userName;
  private String userEmail;
  private LocalDate userDateOfBirth;
}
