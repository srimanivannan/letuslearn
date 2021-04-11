package com.manisrini.domain;

import java.time.Instant;

public class TweetMessage {

  private String postedContent;
  private Instant postedTime;
  private String contentType;
  private Long noOfLikes;
  private Long noOfRetweets;
  private TwitterAccount twitterAccount;

  public TweetMessage(String postedContent, Instant postedTime, String contentType, TwitterAccount twitterAccount) {
    this.postedContent = postedContent;
    this.postedTime = postedTime;
    this.contentType = contentType;
    this.twitterAccount = twitterAccount;
  }

  public TwitterAccount getTwitterAccount() {
    return twitterAccount;
  }

  public void setTwitterAccount(
      TwitterAccount twitterAccount) {
    this.twitterAccount = twitterAccount;
  }

  public String getPostedContent() {
    return postedContent;
  }

  public void setPostedContent(String postedContent) {
    this.postedContent = postedContent;
  }

  public Instant getPostedTime() {
    return postedTime;
  }

  public void setPostedTime(Instant postedTime) {
    this.postedTime = postedTime;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public Long getNoOfLikes() {
    return noOfLikes;
  }

  public void setNoOfLikes(Long noOfLikes) {
    this.noOfLikes = noOfLikes;
  }

  public Long getNoOfRetweets() {
    return noOfRetweets;
  }

  public void setNoOfRetweets(Long noOfRetweets) {
    this.noOfRetweets = noOfRetweets;
  }
}
