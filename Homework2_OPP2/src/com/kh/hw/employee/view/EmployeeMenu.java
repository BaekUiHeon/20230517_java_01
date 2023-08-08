package com.kh.hw.employee.view;
import com.kh.hw.employee.controller.EmployeeController;

import java.util.Scanner;

public class EmployeeMenu{
	Scanner sc=new Scanner(System.in);
	EmployeeController ec=new EmployeeController();
	
	int choice;
	public EmployeeMenu() {
		while(true) {
		System.out.println("1.사원 추가");
		System.out.println("2.사원 수정");
		System.out.println("3.사원 삭제");
		System.out.println("4.사원 출력");
		System.out.println("9.프로그램 종료");
		System.out.print("메뉴 번호를 누르세요:");
		choice=sc.nextInt();
		sc.nextLine();
		if(choice==1)
			insetEmp();
		else if(choice==2)
			updateEmp();
		else if(choice==3)
			deleteEmp();
		else if(choice==4)
			printEmp();
		else if(choice==9) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}	
		else 
			System.out.println("번호를 잘못입력하셨습니다.");}
	}
		
	
	public void insetEmp() {
		int empNo;
		String name;
		char gender;
		String phone;
		char info;
		System.out.print("사원번호:");
		empNo=sc.nextInt();
		System.out.print("사원이름");
		name=sc.nextLine();
		System.out.print("사원성별:");
		gender=sc.nextLine().charAt(0);
		System.out.print("전화번호:");
		phone=sc.nextLine();
		sc.nextLine();
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) :");
		info=sc.nextLine().charAt(0);
		
	
		if(info=='y'||info=='Y') {
			String dept;
			int salary;
		    double bonus;
		    System.out.print("사원부서:");
		    dept=sc.nextLine();
		    System.out.print("연봉:");
		    salary=sc.nextInt();
		    System.out.print("보너스:");
		    bonus=sc.nextDouble();
		    sc.nextLine();
		    ec.add(empNo,name,gender,phone,dept,salary,bonus);
		    }
		else
			ec.add(empNo,name,gender,phone);
	}
	
	
	public void updateEmp(){
		while(true) {
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
		System.out.println("1. 전화번호");
		System.out.println("2. 사원 연봉");
		System.out.println("3. 보너스 율");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호를 누르세요 :");
		int choice=sc.nextInt();
		sc.nextLine();
		if(choice==1) {
			System.out.println("수정할 전화번호:");
			ec.modify(sc.nextLine());
			sc.nextLine();
		}
		else if(choice==2) {
			System.out.println("수정할 사원 연봉:");
			ec.modify(sc.nextInt());
			sc.nextLine();
		}
		else if(choice==3) {
			System.out.println("수정할 보너스율:");
			ec.modify(sc.nextDouble());
			sc.nextLine();
		}
		else if(choice==9) {
			break;
		}
		else {
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		}
	}
			
		
		
		
		
		
				// 사용자가 수정하고 싶은 내용에 대한 번호를 입력하면
				// 수정할 XXX : 라고 안내문을 출력 후 사용자에게 값을 받고
				// 받은 값을 EmployeeController의 modify() 인자로 넣어 전달
				// 9번을 입력하면 “메인메뉴로 돌아갑니다” 출력 후 메인 메뉴로
				// 잘못 입력할 경우 “잘못 입력하셨습니다.” 출력 후 메인메뉴로

	} // TO DO

	void deleteEmp() {ec.remove();}
	void printEmp() {ec.inform();} 
}
