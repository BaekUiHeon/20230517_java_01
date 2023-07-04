package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice1 {
	
	public VariablePractice1() {
		super();
	}
	
	
	public static int cnt = 10;
	/*
	 * 	이름, 성별, 나이, 키를 사용자에게 입력 받아 각각의 값을 변수에 담고 출력하세요.
		ex.
		이름을 입력하세요 : 아무개
		성별을 입력하세요(남/여) : 남
		나이를 입력하세요 : 20
		키를 입력하세요(cm) : 180.5
		키 180.5cm인 20살 남자 아무개님 반갑습니다^^
	 */
	public void method1() {
		System.out.println("여기 실행됨 여기코딩함");
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("성별을 입력하세요(남/여) : ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("키를 입력하세요(cm) : ");
		double height = sc.nextDouble();
		System.out.println("키 "+height+"cm인 "+age+"살 "+gender+"자 "+name+"님 반갑습니다^^");

	}
	
	/* Question2
	 * 키보드로 정수 두 개를 입력 받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요.
	 */
	public void method2() {
		System.out.println("여기2 실행됨 여기코딩함");
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 정수 : "); 
		int num1 = scan.nextInt();
		System.out.print("두 번째 정수 : "); 
		int num2 = scan.nextInt();
//		int result1 = (num1+num2);
		
		System.out.println("더하기 결과 : "+(char)(num1+num2)); 
		System.out.println("빼기 결과 : "+(num1-num2)); 
		System.out.println("곱하기 결과 : "+(num1*num2)); 
		System.out.println("나누기 몫 결과 : "+(num1/num2)); 
	}
	/* Question3
	 * 키보드로 가로, 세로 값을 값을 실수형으로 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 계산 공식 ) 	면적 : 가로 * 세로
	 *	    	둘레 : (가로 + 세로) * 2
	 */
	public void method3() {
		Scanner scan = new Scanner(System.in);
		System.out.print("가로 : "); 
		double width = scan.nextDouble();
		System.out.print("세로 : "); 
		double height = scan.nextDouble();
		
		System.out.println("면적 : "+(width*height)); 
		System.out.println("둘레 : "+((width+height)*2)); 
	}

	/* Question4
	 * 영어 문자열 값을 키보드로 입력 받아 문자에서 앞에서 세 개를 출력하세요.
	 */
	public void method4() {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : "); 
		String str = scan.nextLine();
		
		System.out.println("첫 번째 문자 : "+str.charAt(0)); 
		System.out.println("두 번째 문자 : "+str.charAt(1)); 
		System.out.println("세 번째 문자 : "+str.charAt(2)); 
	}
}
