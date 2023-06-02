package com.kh.hw.shape.controller;
import com.kh.hw.shape.model.vo.Shape;

public class TriangleController {
	
	Shape s=new Shape();
	
	public double calcArea(double height,double width) {
		s=new Shape(2,height,width);
		return width*height/2;
	}
	public void paintColor(String color) {  // setter을 통해 받은 매개변수로 값 변경 
		s.setColor(color);
	}
	
	public String print() { // 모양과 Shape의 information메소드 반환 값 합쳐 함께 반환 
		return "Triangle:"+s.information();
	}

}
