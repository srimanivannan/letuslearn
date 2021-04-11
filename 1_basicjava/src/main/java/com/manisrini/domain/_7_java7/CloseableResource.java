package com.manisrini.domain._7_java7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CloseableResource {
	
	public void testTryWithResourcesStatement1() {
		
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
		try {
			URL resource = getClass().getClassLoader().getResource("java7filetest.txt");
			Path path = Paths.get(resource.toURI()); // Paths news class in java7
			List<String> lines = Files.readAllLines(path); // Files API in java7
			System.out.println(lines);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CloseableResource closeableResource = new CloseableResource();
		closeableResource.testTryWithResourcesStatement1();
	}
}
