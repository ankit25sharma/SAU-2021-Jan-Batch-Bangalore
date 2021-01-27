package com.au.springproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingApp {
	
	public static void main(String[] args) {
	
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Rectangle rectangle = (Rectangle) factory.getBean("rectangle");
		
		rectangle.draw();
				
	}
}
