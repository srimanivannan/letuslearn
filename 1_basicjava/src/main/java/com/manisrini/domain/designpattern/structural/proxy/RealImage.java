package com.manisrini.domain.designpattern.structural.proxy;

public class RealImage implements Image {

	private String imagefilename;
	
	public RealImage(String imagefilename){
		this.imagefilename=imagefilename;
	}
	@Override
	public void imageDisplay(String fromdemo){
		System.out.println("Displaying:"+fromdemo+":"+imagefilename);
	}
}
