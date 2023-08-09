package com.kh.practice.point.view;
import java.util.Scanner;
import com.kh.practice.point.controller.RectangleController;
import com.kh.practice.point.controller.CircleController;

public class PointMenu {
	private Scanner sc= new Scanner(System.in);
	private CircleController cc=new CircleController();
	private RectangleController rc =new RectangleController();
	
	public void mainMenu() {
		int choice=0;
		while(true) {
			System.out.println("===== 메뉴 =====");
            System.out.println("1. 원");
            System.out.println("2. 사각형");
            System.out.println("9. 끝내기");
            System.out.print("메뉴 번호: ");
            choice=sc.nextInt();
            if(choice==1) 
            	circleMenu();
            else if(choice==2)
            	rectangleMenu();
            else if(choice==9)
            	break;
		}
		sc.close();
	}
	public void circleMenu(){
		System.out.println("===== 원 메뉴 =====");
        System.out.println("1. 원 둘레");
        System.out.println("2. 원 넓이");
        System.out.println("9. 메인으로");
        System.out.print("메뉴 번호: ");
        int choice = sc.nextInt();
        if(choice==1) {
        	calcCircum();
        }
        else if(choice==2) {
        	calcCircleArea();
        }
        else if(choice==9) {
        	return;
        }
        else return;
        	
	}
	public void rectangleMenu(){

        System.out.println("===== 메뉴 =====");
        System.out.println("1. 사각형 둘레");
        System.out.println("2. 사각형 넓이");
        System.out.println("3. 메인으로");
        System.out.print("메뉴 번호: ");
        int choice = sc.nextInt();
        if(choice==1) {
        	calcPerimeter();
        }
        if(choice==2) {
        	calcRectArea();
        }

	}
	public void calcCircum() {
		System.out.print("x:");
		int x=sc.nextInt();
		System.out.print("y:");
		int y=sc.nextInt();
		System.out.print("반지름:");
		int radius=sc.nextInt();
		System.out.println(cc.calcCircum(x, y, radius));}
	
	public void calcCircleArea() {
			System.out.print("x:");
			int x=sc.nextInt();
			System.out.print("y:");
			int y=sc.nextInt();
			System.out.print("반지름:");
			int radius=sc.nextInt();
			System.out.println(cc.calcArea(0, 0, radius));}
	public void calcPerimeter() {
		System.out.print("x:");
		int x=sc.nextInt();
		System.out.print("y:");
		int y=sc.nextInt();
		System.out.print("너비:");
		int width=sc.nextInt();
		System.out.print("높이:");
		int height=sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, width, height));
		}
	public void calcRectArea() {
		System.out.print("x:");
		int x=sc.nextInt();
		System.out.print("y:");
		int y=sc.nextInt();
		System.out.print("너비:");
		int width=sc.nextInt();
		System.out.print("높이:");
		int height=sc.nextInt();
		System.out.println(rc.calcArea(x, y, width, height));}
}
