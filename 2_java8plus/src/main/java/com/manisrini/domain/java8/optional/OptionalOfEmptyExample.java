package com.manisrini.domain.java8.optional;

import java.time.Instant;
import java.util.Optional;

import com.manisrini.domain.TweetMessage;
import com.manisrini.domain.TwitterAccount;


public class OptionalOfEmptyExample {

  public static void main(String[] args) {
    Optional<TweetMessage> empty = Optional.empty();
    Optional<TweetMessage> of = Optional.of(tweetWithAccount());

  }

  private static TweetMessage tweetWithAccount() {
    return new TweetMessage("hi", Instant.now(),"text", getTwitterAccount());
  }

  private static TwitterAccount getTwitterAccount() {
    TwitterAccount twitterAccount = new TwitterAccount();
    twitterAccount.setName("name");
    return twitterAccount;
  }
}
