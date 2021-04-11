package com.manisrini.domain._1_oops.oops.polymor;

/**
 * The Class OverLoading.
 */
public class OverLoading {
    
    /**
     * Address.
     * @param country the country
     */
    public static final void address(String country) {
        System.out.println("country=>" + country);
    }

    /*public static final int address(String country,String state){
		System.out.println("country=>"+country);
		System.out.println("state=>"+state);
		return 0;
	}*/
    
    /**
     * Address.
     * @param country the country
     * @param state the state
     */
    public static final void address(String country, String state) {
        System.out.println("country=>" + country);
        System.out.println("state=>" + state);
    }

    /**
     * The main method.
     * @param args the arguments
     */
    public static void main(String[] args) {
        OverLoading.address("india");
        OverLoading.address("india", "TN");
    }

}
