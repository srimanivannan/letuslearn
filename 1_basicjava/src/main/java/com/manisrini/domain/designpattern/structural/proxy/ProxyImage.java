package com.manisrini.domain.designpattern.structural.proxy;

public class ProxyImage implements Image {
	private String imagefilename;
	private RealImage realImage = null;
	public ProxyImage(String imagefilename){
		this.imagefilename=imagefilename;
	}
	@Override
	public void imageDisplay(String fromdemo){
		if(realImage==null){
			System.out.println("if(realImage==null){");
			realImage = new RealImage(this.imagefilename);
		}
		System.out.println("ProxyImage imageDisplay");
		realImage.imageDisplay(fromdemo);
	}
}
