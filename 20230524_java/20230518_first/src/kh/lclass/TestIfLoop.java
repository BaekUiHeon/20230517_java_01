package kh.lclass;

import java.util.Scanner;

public class TestIfLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("나이를 입력해주세요. 정수 0~200 : ");
		int age = sc.nextInt();
		// 8살부터 - 19살까지 학교에 다닙니다.
		// 8살이면 학교에 입학하였습니다.
		// 19살이면 곧 졸업합니다.
		// 그외 학교에 다니지 않습니다.
		if (age >= 8 && age <= 19) {
			System.out.println("학교에 다닙니다.");
			if (age == 8) {
				System.out.println("학교에 입학하였습니다.");
			} else if (age == 19) {
				System.out.println("곧 졸업합니다");
			}
		} else {
			System.out.println("학교에 다니지 않습니다.");
		}

		System.out.println("==============");
		System.out.println("공원입장료");
		System.out.print("나이를 입력해주세요: ");
		// 교재 97 flow chart 보면서 작성해주세요.
		int age1 = 0;
		int charge = 1000;
		age1 = sc.nextInt();
		if (age1 >= 8) {
			charge = 2000;
			if(age1 >= 14) {
				charge = 2500;
			} else if(age1 >= 20) {
				charge = 3000;
			}
		} 
		
//		8세미만 
//		14세미만
		
//		20세 이상
//		15세 이상
		System.out.println("요금은 "+charge+"원 입니다.");
		System.out.println("==============");

		
		System.out.println("==============");
		System.out.println("=== 학점 ====");
		System.out.print("평균점수를 입력하세요: ");
		int totalScore = sc.nextInt();
		int score = totalScore / 10;  // 10으로 나눈 몫 (정수연산이므로)
		// 100 ==> 10
		// 99 ==> 9, 90~99 ==> 9
		// 80-89 ==> 8
		// switch - case 문은 비교문의 규칙성이 있을때 사용하면 좋음.
		switch(totalScore / 10) {
		case 10:// if
		case 9:
			System.out.println("A학점입니다.");
			break;
		case 8:// else if -
			System.out.println("B학점");
			break;
		case 7:// else if -
			System.out.println("C학점");
			break;
		case 6: // else if - 
			System.out.println("D학점");
			break;
		default:  // else
			System.out.println("과락입니다.");
			break;
		}
		
		
		System.out.println("==============");
		
		
		// 1~100 정수의 합을 구하시오
		int i;
		int sum = 0;
		//for( 1.초기값설정 ; 2.5.8조건식 ; 4.7증감식 ) {
		for( i=101 ; i<=100 ; i=i+1)  {
			// 3.6.10 여기
			sum += i;
		}
		
		// 화면에 1-5까지 display 해줘
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		
		
		
		
		
		
		
		sc.close();
	}

}


















