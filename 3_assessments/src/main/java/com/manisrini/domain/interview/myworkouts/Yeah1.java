package com.manisrini.domain.interview.myworkouts;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Yeah1 {

  public static void main(String[] args) {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("nashorn");
    try {
      engine.eval(
          "var i =0;" + "i++" + "var String = Java.type(\"java.lang.String\");"+"var str = new String(\"Java\");"+"print(str);"+"print(i);"
      );

    }catch (Exception e) {
      System.out.println("ex");
    }
  }
}
