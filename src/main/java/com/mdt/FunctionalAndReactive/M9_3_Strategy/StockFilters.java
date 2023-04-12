package com.mdt.FunctionalAndReactive.M9_3_Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilters {
//
//    public static List<Stock> bySymbol(List<Stock> list, String symbol) {
//        var filteredData = new ArrayList<Stock>();
//
//        for (var stock : list) {
//            if (stock.getSymbol().equals(symbol))
//                filteredData.add(stock);
//        }
//        return filteredData;
//    }
//
//    public static List<Stock> byPriceAbove(List<Stock> list, double price) {
//        var filteredData = new ArrayList<Stock>();
//
//        for (var stock : list) {
//            if (stock.getPrice() > price)
//                filteredData.add(stock);
//        }
//        return filteredData;
//    }

    public static List<Stock> filter(List<Stock> list, Predicate<Stock> p) {
        var filteredData = new ArrayList<Stock>();

        for (var stock : list) {
            if (p.test(stock))
                filteredData.add(stock);
        }
        return filteredData;
    }
}
