package com.manisrini.domain;

public class Stock {

  public String ticker;
  public Integer price;

  public String getTicker() {
    return ticker;
  }

  public Integer getPrice() {
    return price;
  }

  public Stock(String theTicker, Integer thePrice) {
    ticker = theTicker;
    price = thePrice;
  }

  @Override
  public String toString() {
    return "Stock [ticker=" + ticker + ", price=" + price + "]";
  }
}
