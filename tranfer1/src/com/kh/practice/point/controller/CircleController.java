package com.kh.practice.point.controller;
import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private static final double PI=3.14;
	private Circle c;
	
	public String calcArea(int x,int y,int radius) {
		c=new Circle(x,y,radius);
		return ""+radius*radius*PI;
		}
	public String calcCircum(int x,int y,int radius) {
		c=new Circle(x,y,radius);
		return ""+PI*radius*2;
		}
}
