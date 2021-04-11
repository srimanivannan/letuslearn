package com.manisrini.domain;

import java.time.Instant;

public class TwitterAccount {

  private String name;
  private Instant joinedOn;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getJoinedOn() {
    return joinedOn;
  }

  public void setJoinedOn(Instant joinedOn) {
    this.joinedOn = joinedOn;
  }
}
