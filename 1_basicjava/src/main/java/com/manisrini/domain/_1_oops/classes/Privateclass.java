package com.manisrini.domain._1_oops.classes;

/**
 * Outer class can not be private
 */
public class Privateclass {

	private class InnerClass // Can not be referenced from outside of this current class due to private
    {
        public void InnerMethod()
        { 
        	System.out.println("Private Inner Class!"); 
        }
    }
	final private class FinalInnerClass // Can not be referenced from outside of this current class due to private
    {
        public void InnerMethod()
        { 
        	System.out.println("final Private Inner Class!"); 
        }
    }
	final static private class SaticInnerClass // Can not be referenced from outside of this current class due to private
    {
        public static void InnerMethod()
        { 
        	System.out.println("final static Private Inner Class!"); 
        }
    }
	public static void main(String[] args) {
		
		new Privateclass().new InnerClass().InnerMethod();
		new Privateclass().new FinalInnerClass().InnerMethod();
		SaticInnerClass.InnerMethod();
	}

}
