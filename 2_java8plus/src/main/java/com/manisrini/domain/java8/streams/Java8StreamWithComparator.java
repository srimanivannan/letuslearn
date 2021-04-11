package com.manisrini.domain.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8StreamWithComparator {

    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(new Stock("A", 12), new Stock("B", 5));
        stocks.stream()
        //.sorted(Comparator.comparing(stock -> stock.price).reversed()); //ERROR
        //.sorted(Comparator.comparing((Stock stock) -> stock.ticker).reversed()); //OK
        .sorted(Comparator.comparing((Stock stock) -> stock.getPrice()).reversed()); //ERROR
        //.sorted(Comparator.comparing((Stock stock) -> stock.getTicker()).reversed()); // OK
        //.sorted(Comparator.comparing(Stock::getTicker).reversed()) //OK
        //.sorted(Comparator.comparing(Stock::getPrice));
        System.out.println(stocks);
    }
}

class Stock {
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