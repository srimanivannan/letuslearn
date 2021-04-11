package com.manisrini.domain._1_oops.classes;

public class Protectedclass {

	protected final class FinalInnerClass // can be referenced with in this package
    {
        public void InnerMethod()
        { 
        	System.out.println("FinalInnerClass Inner Class!"); 
        }
    }
	protected final static class FinalStaticInnerClass // can be referenced with in this package
    {
        public static void InnerMethod()
        { 
        	System.out.println("FinalStaticInnerClass Inner Class!"); 
        }
    } 
	
	protected class InnerClass // can be referenced with in this package
    {
        public void InnerMethod()
        { 
        	System.out.println("Protected Inner Class!"); 
        }
    } 
	
	public static void main(String[] args) {
	
		new Protectedclass().new FinalInnerClass().InnerMethod(); // can be referenced with in this package
    Protectedclass.FinalStaticInnerClass.InnerMethod(); // can be referenced with in this package
    FinalStaticInnerClass.InnerMethod(); // just you don't need outer class name
    new Protectedclass().new InnerClass().InnerMethod(); // can be referenced with in this package
	}

}
