package com.manisrini.domain._6_java6.webservice.rpcstyle;

import javax.xml.ws.Endpoint;

public class PublishEndpoint {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/stock", new StockPriceImpl());
		//This will generate the WSDL file.
		//if you want see the WSDL file. Please open a browser and type the below
		//http://localhost:8080/stock?WSDL
	}
}
