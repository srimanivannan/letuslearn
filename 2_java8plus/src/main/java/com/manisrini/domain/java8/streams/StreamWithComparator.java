package com.manisrini.domain.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.manisrini.domain.Stock;

public class StreamWithComparator {

    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(new Stock("A", 12), new Stock("B", 5));
        stocks.stream()
        //.sorted(Comparator.comparing(stock -> stock.price).reversed()); //ERROR
        //.sorted(Comparator.comparing((Stock stock) -> stock.ticker).reversed()); //OK
        .sorted(Comparator.comparing(Stock::getPrice).reversed()); //ERROR
        //.sorted(Comparator.comparing((Stock stock) -> stock.getTicker()).reversed()); // OK
        //.sorted(Comparator.comparing(Stock::getTicker).reversed()) //OK
        //.sorted(Comparator.comparing(Stock::getPrice));
        System.out.println(stocks);
    }
}