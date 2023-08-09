package kh.lclass.bank;

import java.util.Scanner;

public class Member {

	public static void main(String[] args) {
		// 스캐너 마련
		Scanner sc = new Scanner(System.in);
		
		System.out.println("통장계설을 원하십니까?");
		String answer = sc.nextLine();
		if(answer.equals("네")) {   // (answer=="네") 문자 == 비교할 수 없음.
			
			System.out.println("주민번호 확인: ");
			String strNo = sc.nextLine();
			//int strNo = sc.nextInt(); sc.nextLine();
			int sno = Integer.parseInt(strNo);
			
			System.out.println("이름 확인: ");
			String strName = sc.nextLine();
			BankAccount ej = new BankAccount(sno, strName);
			BankAccount hj = new BankAccount(123123, "종호", 1012131212);
			
			BankAccount jh = new BankAccount();
			System.out.println(jh.getSno());  // 0
			System.out.println(jh.getName());  // null 
			System.out.println(jh.getBalance());  // 0  --> 5000000 
			System.out.println(jh.getAccountName());  // 내일배움
			jh.sumArgs(2,5,3);
			
			
			jh.sum(1, 3);
			jh.sum("11", 22);
			jh.sum(1, 3,3);
			
		}else {
			System.out.println("다른 창구를 이용해주세요.");
		}
		
	}
}








