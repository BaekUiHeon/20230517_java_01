package com.kh.practice.point.model.vo;

public class Point {
	private int x;
	private int y;
	
	public Point() {} //TODO
	public Point(int x,int y) {}//TODO
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}	
}