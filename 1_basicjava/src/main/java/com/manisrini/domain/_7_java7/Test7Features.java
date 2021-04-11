package com.manisrini.domain._7_java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test7Features {
	
	/*
	 * Switch case accepts string as a parameter. earlier it accepts int,byte,short..
	 */
	public void testStringInSwitch(String param){
	       final String mani = "mani";
	       final String suganthi = "suganthi";
	       final String amma = "amma";
	       switch (param) {
	           case mani:
	               System.out.println(mani);
	               break;
	           case suganthi:
	               System.out.println(suganthi);
	               break;
	           case amma:
	               System.out.println(amma);
	               break;
	       }
	   }
	/* can accepts the binary value of integer and vise vesa.
	 * Java code, due to its C heritage, has traditionally forced programmers to represent numbers in only decimal, octal, or hexadecimal.
	 * As quite a few domains are bit orientated, this restriction can introduce errors. You can now create binary numbers using an 0b prefix.
	 */
	public void testBinaryIntegralLiterals(){
		 
        int a = 0b1000; //2^3 = 8
 
        if (a == 8){
            System.out.println(true);
        } else{
            System.out.println(false);
        }
        
        int b=8;
        if (0b1000 == b){
            System.out.println(true);
        } else{
            System.out.println(false);
        }
}
	/*
	 * 	Long numbers are hard to read. You can now split them up using an underscore in ints and longs:
	 *  Underscores in numeric literals.
	*/
	public void testUnderscoresNumericLiterals() {
		 
	    int oneMillion_ = 1_000_000; //new in Java7
	    int oneMillion = 1000000;
	 
	    if (oneMillion_ == oneMillion){
	        System.out.println(true);
	    } else{
	        System.out.println(false);
	    }

	}
	/*
	 * This is called the diamond operator: <> which infers the type from the reference declaration.
	 * As you can see in the right part of the assignment in old lines you need to repeat your type information 
	 * for the listOfMaps variable as well as of the aMap variable. This isn�t necessary anymore in Java 7:
	 */
	public void testDiamond(){

		 //Old Java 6
	      /*List<Map<Date, String>> listOfMaps = new ArrayList<Map<Date, String>>(); // type information twice!
	      HashMap<Date, String> aMap = new HashMap<Date, String>(); // type information twice
	      aMap.put(new Date(), "Hello");
	      listOfMaps.add(aMap);
	      System.out.println(listOfMaps);*/
	      
		 //Old Java 7
	      List<Map<Integer, String>> listOfMaps = new ArrayList<>(); // type information once!
	     
	      HashMap<Integer, String> aMap = new HashMap<>(); // type information once!
	      aMap.put(1, "Mani");
	      aMap.put(2, "Suganthi");
	      
	      listOfMaps.add(aMap);
	      
	      System.out.println("Diamond=>"+listOfMaps);
	    
	}
	public void testMulticatch(){
	 try {  
		   Class<?> string = Class.forName("java.lang.String");  
		   //string.getMethod("length11").invoke("test");  
		   string.getMethod("length").invoke("test");
	  } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {  
	   // do something, and only write it once!!! 
		  e.printStackTrace();
	  }
	}
	
	/*
	 * Some resources in Java need to be closed manually like InputStream, Writers, Sockets, Sql classes. 
	 * This language feature allows the try statement itself to declare one of more resources. 
	 * These resources are scoped to the try block and are closed automatically.
	 */
	
	public void testTryWithResourcesStatement() {
		
		//java 6
		/*
		      FileInputStream in = null;
    			try {
        			in = new FileInputStream("java7.txt");
        			System.out.println(in.read());
    			} finally {
        			if (in != null) {
            		in.close();
        		}
    		}
		 */
		//java 7
		String file1 = getClass().getClassLoader().getResource("java7filetest1.txt").getFile();
		String file2 = getClass().getClassLoader().getResource("java7filetest2.txt").getFile();
		
	    try (BufferedReader br1 = new BufferedReader(new FileReader(file1));
	    	 BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
	        System.out.println(br1.readLine());
	        System.out.println(br2.readLine());
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
	}

	public static void main(String args[]){
		Test7Features test7object = new Test7Features();
		//test7object.testStringInSwitch("mani");
		//test7object.testBinaryIntegralLiterals();
		//test7object.testUnderscoresNumericLiterals();
		//test7object.testDiamond();
		//test7object.testMulticatch();
		test7object.testTryWithResourcesStatement();
	}
}
