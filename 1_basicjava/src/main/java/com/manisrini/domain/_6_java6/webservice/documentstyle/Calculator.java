package com.manisrini.domain._6_java6.webservice.documentstyle;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
//@SOAPBinding(style = Style.RPC, use=Use.LITERAL)
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public class Calculator {

  @WebMethod(operationName = "addNumbers", action = "POST")
  public int add(@WebParam(name = "number1", mode = Mode.IN) int number1,
			@WebParam(name = "number2", mode = Mode.IN)int number2) {
    return number1 + number2;
  }
}
