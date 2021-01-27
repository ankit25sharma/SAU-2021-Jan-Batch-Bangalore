package com.au.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Rectangle {
	
	@Autowired
	@Qualifier("PointA")
	private Point a;
	
	@Autowired
	@Qualifier("PointB")
	private Point b;
	
	@Autowired
	@Qualifier("PointC")
	private Point c;
	
	@Autowired
	@Qualifier("PointD")
	private Point d;
	
	@Autowired
	@Qualifier("height")
	private int height;
	
	@Autowired
	@Qualifier("width")
	private int width;

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}
	
	public Point getD() {
		return d;
	}
	
	public void setD(Point d) {
		this.d = d;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void draw() {
		  System.out.println("PointA: "+"X1: "+getA().getX()+" Y1: "+getA().getY()+"\nPointB: " + "X2: "
				  + getB().getX()+" Y2: "+getB().getY() + "\nPointC: "+ "X3: "+getC().getX()+" Y3: "+getC().getY()+ "\nPointD: "+ "X: "+getD().getX()+" Y: "+getD().getY());
		  System.out.println("Rectangle height: "+getHeight()+"\nRectangle width: "+getWidth());
		  }
}
