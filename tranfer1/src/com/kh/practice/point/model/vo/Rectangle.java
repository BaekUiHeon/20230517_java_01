package com.kh.practice.point.model.vo;

public class Rectangle extends Point {
	private int width;
	private int height;
	
	public Rectangle() {}
	public Rectangle(int x,int y,int width,int height) {}
	
	


	public int getX() {
		return getX();
	}
	public void setX(int x) {
		setX(x);
	}
	public int getY() {
		return getX();
	}
	public void setY(int x) {
		setX(x);
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {return super.toString()+", getWidth="+getWidth()+", getHeight="+getHeight();}
}
