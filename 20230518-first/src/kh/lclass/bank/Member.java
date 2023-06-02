package kh.lclass.bank;

import java.util.Scanner;

public class Member {
	
	public static void main(String[] args) {
		// 스캐너 마련
		Scanner sc = new Scanner(System.in);
		
		System.out.println("통장계설을 원하십니다?");
		String answer = sc.nextLine();
		if(answer.equals("네")) {  //(answer=="네") 문자 == 비교할 수 없음.
			System.out.println("주민번호 확인:");
//			int strNo = sc.nextInt(); sc.nextLine();
			String strNo = sc.nextLine();
			int sno = Integer.parseInt(strNo);
			
			System.out.println("이름 확인:");
			String strName = sc.nextLine();
			BankAccount ej = new BankAccount(sno, strName);
			BankAccount hj = new BankAccount(123123, "종호", 101231212);
			
			BankAccount jh = new BankAccount();
			System.out.println(jh.getSno()); // 0
			System.out.println(jh.getName()); // null
			System.out.println(jh.getBalance()); // 0 --> 5000000
			System.out.println(jh.getAccountName()); // 내일배움
			jh.sumArgs(2,5,3);
			
			
			jh.sum(1, 3);
			jh.sum("11", 22);
			jh.sum(1, 3,3);
			
			String str1="문자";
			String str2="문자";
			String str3=new String();
			String str4=new String("문자");
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3);
			System.out.println(str4);
			
			System.out.println(jh.hashCode());
			System.out.println(jh.toString());
			
			System.out.println(jh.getSno().MAX_VALUE);
			System.out.println(jh.getSno().MIN_VALUE);
			
		}else {
			System.out.println("다른 창구를 이용해주세요.");
		}
		
		
	}
}
