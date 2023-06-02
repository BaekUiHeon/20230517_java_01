package com.kh.practice.point.model.vo;

public class Circle extends Point {
	private int radius;
	public Circle() {}
	public Circle(int x,int y,int radius){}//TODO
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void setX(int x) {
		super.setX(x);
	}	
	public int getX() {
		return super.getX();
	}	
	public void setY(int y) {
		super.setX(y);
	}
	public int getY() {
		return super.getY();
	}
	
	public String toString() {return super.toString()+", radius="+radius;}

}
