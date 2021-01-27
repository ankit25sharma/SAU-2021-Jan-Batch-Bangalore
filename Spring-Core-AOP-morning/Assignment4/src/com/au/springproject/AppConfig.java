package com.au.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(name="rectangle")
	public Rectangle getTriangle() {
		return new Rectangle();
	}
	
	@Bean(name="PointA")
	public Point getPointA() {
		return new Point(0,0);
	}
	@Bean(name="PointB")
	public Point getPointB() {
		return new Point(100,0);
	}
	@Bean(name="PointC")
	public Point getPointC() {
		return new Point(100,50);
	}
	@Bean(name="PointD")
	public Point getPointD() {
		return new Point(0,50);
	}
	
	@Bean(name="height")
	public int getHeight() {
		return 50;
	}
	
	@Bean(name="width")
	public int getWidth() {
		return 100;
	}
	
}