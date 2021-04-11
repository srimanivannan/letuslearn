package com.manisrini.domain._6_java6.webservice.rpcstyle;

import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="com.raminus.workshop.corejava8.corejava._6_java6.webservice.rpcstyle.StockPrice")
public class StockPriceImpl implements StockPrice {

	@Override
	public String getStockPrice(String stockId) {
		Random rand = new Random();
		return "Price of " + stockId + " is:" + rand.nextInt(10);
	}
	
}
