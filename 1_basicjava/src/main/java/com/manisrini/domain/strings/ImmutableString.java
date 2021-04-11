package com.manisrini.domain.strings;

public class ImmutableString {

	
        public static void testEquals() {
        
            String s1="hello";
            String s2="hel"+"lo";
            String s3=" mum";
            
            if(s1 == s2) {
                System.out.println("1. same");
            } else {
                System.out.println("1. different");
            }
            
            if ((s1 + s3) == "hello mum") {
                System.out.println("2. same");
            } else {
                System.out.println("2. different");
            }    
            
        }
        
	public static void main(String[] args) {
	
		
		String s1="mani";
		String s2="mani";
		String s3="mani";
		String s4="mani";

		s3="cool";
				
		System.err.println("s1 value=>"+s1);
		System.err.println("s2 value=>"+s2);
		System.err.println("s3 value=>"+s3);
		System.err.println("s4 value=>"+s4);
		
		System.err.println(s1.hashCode());
		System.err.println(s2.hashCode());
		System.err.println(s3.hashCode());
		System.err.println(s4.hashCode());
		
                System.err.println("Look same hashcode for s1 s2 s4");
                        
		String test1 = new String ("welcome");
		String test2 = new String ("welcome");
		System.out.println(test1==test2); // This is false because of new instance
		System.out.println(test1.equals(test2)); // This is true because of content of strings
                
		System.err.println("test1 hascode=>"+test1.hashCode());
		System.err.println("test2 hascode=>"+test2.hashCode());
                //Both the hash codes are same because string literal pool
                
                testEquals();
	}

}
