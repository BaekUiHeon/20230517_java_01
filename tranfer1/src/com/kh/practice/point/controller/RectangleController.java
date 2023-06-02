package com.kh.practice.point.controller;
import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	
	private Rectangle r;
	
	public String calcArea(int x, int y, int width,int height)
	{
		r=new Rectangle(x,y,width,height);
		return ""+width*height;
	}
	public String calcPerimeter(int x, int y, int width,int height) {
		r=new Rectangle(x,y,width,height);
		return ""+2*(width+height);
	}
}
