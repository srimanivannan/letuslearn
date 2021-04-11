package com.manisrini.domain._6_java6.rohinoscripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestRohino {


	public static void main(String[] args) {
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		//Now javascript engine is initiated.
		//it is ready for use
		try {
			engine.eval("alert('hi')");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

}
