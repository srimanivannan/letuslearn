package com.manisrini.domain._6_java6.webservice.rpcstyle;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
//@SOAPBinding(style=Style.RPC)
public interface StockPrice {

  @WebMethod
  String getStockPrice(String stockId);
}
