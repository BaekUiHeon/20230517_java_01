package com.kh.hw.shape.view;

import java.util.Scanner;
import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();

	public void inputMenu() {
		int choice = 0;
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형 ==> triangleMenu()");
			System.out.println("4. 사각형 ==> squareMenu()");
			System.out.println("9. 프로그램 종료 => “프로그램 종료” 출력 후 프로그램 종료");
			System.out.print("메뉴 번호 :");
			choice = sc.nextInt();
			sc.nextLine();
			 if (choice == 3) 
				this.triangleMenu();
			 else if (choice == 4) 
				this.squareMenu();
			 else if (choice == 9)
				break;
			 else
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
		}
	}

	public void triangleMenu() {
		int choice = 0;
		while (true) {
			System.out.println(" ===== 삼각형 =====");
			System.out.println("1. 삼각형 면적 ==> inputSize()");
			System.out.println("2. 삼각형 색칠 ==> inputSize()");
			System.out.println("3. 삼각형 정보 ==> printInformation()");
			System.out.println("9. 메인으로 ==> “메인으로 돌아갑니다.");
			System.out.print("메뉴 번호:");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1)
				this.inputSize(3, choice);
			else if (choice == 2)
				this.inputSize(3, choice);
			else if (choice == 3)
				this.printInformation(3);
			else if (choice == 9) {
				System.out.println("메인으로 돌아갑니다");
				this.inputMenu();
				break;
			} 
			else
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
		}
	}

	public void squareMenu() {
		int choice = 0;
		while (true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1.사각형 둘레 ==> inputSize()");
			System.out.println("2.사각형 면적 ==> inputSize()");
			System.out.println("3.사각형 색칠 ==> inputSize()");
			System.out.println("4.사각형 정보 ==> printInformation()");
			System.out.println("9. 메인으로 ==> “메인으로 돌아갑니다.” 출력 후 inputMenu()로");
			System.out.println("메뉴 번호 :");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1) {
				this.inputSize(4, choice);
			} else if (choice == 2) {
				this.inputSize(4, choice);
			} else if (choice == 3) {
				this.inputSize(4, choice);
			} else if (choice == 4) {
				this.printInformation(4);
			}
			else if (choice == 9) {
				this.inputMenu();
				break;
			} else
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
		}
	}

	public void inputSize(int type, int menuNum) {
		if (type == 3) {
			if (menuNum == 1) {
				System.out.print("높이를 입력하시오:");
				double height = sc.nextDouble();
				System.out.print("너비를 입력하시오:");
				double width = sc.nextDouble();
				sc.nextLine();
				System.out.println("삼각형면적:" + tc.calcArea(height, width));
				this.printInformation(3);
			}
			if (menuNum == 2) {
				sc.nextLine();
				System.out.print("색깔을 입력하시오:");
				String color = sc.nextLine();
				tc.paintColor(color);
				System.out.println("색깔이 수정되었습니다.");
			}
		}
		if (type == 4) {
			if (menuNum == 1) {
				System.out.print("높이를 입력하시오:");
				double height = sc.nextDouble();
				System.out.print("너비를 입력하시오:");
				double width = sc.nextDouble();
				System.out.println("사각형면적:" + scr.calcPerimeter(height, width));
				this.printInformation(4);
			} else if (menuNum == 2) {
				System.out.print("높이를 입력하시오:");
				double height1 = sc.nextDouble();
				System.out.print("너비를 입력하시오:");
				double width1 = sc.nextDouble();
				System.out.println("사각형 넓이:" + scr.calcArea(height1, width1));
				this.printInformation(4);
			} else if (menuNum == 3) {
				sc.nextLine();
				System.out.print("색깔을 입력하시오:");
				String color = sc.nextLine();
				scr.paintColor(color);
				System.out.println("색깔이 수정되었습니다.");
			}
		}
	}

	void printInformation(int type) {
		if (type == 3)
			System.out.println(tc.print());
		if (type == 4)
			System.out.println(scr.print());

	}
}
