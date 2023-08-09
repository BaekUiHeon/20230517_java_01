package com.kh.hw.employee.view;

import java.util.Scanner;
import com.kh.hw.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();

	public EmployeeMenu() {

		while (true) {
			System.out.println("1. 사원 추가 ==> insertEmp()");
			System.out.println("2. 사원 수정 ==> updateEmp()");
			System.out.println("3. 사원 삭제 ==> deleteEmp()");
			System.out.println("4. 사원 출력 ==> printEmp()");
			System.out.println("9. 프로그램 종료 ==> “프로그램을 종료합니다.” 출력 후 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			if (choice == 1)
				insertEmp();
			else if (choice == 2)
				updateEmp();
			else if (choice == 3)
				deleteEmp();
			else if (choice == 4)
				printEmp();
			else if (choice == 9) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			} else
				System.out.println("번호를 잘못 입력하셨습니다.");
		}
	}

	public void insertEmp() {
		System.out.print("사원번호: ");
		int empNo = sc.nextInt();
		sc.nextLine();

		System.out.print("사원이름: ");
		String Name = sc.nextLine();
		System.out.print("사원성별: ");
		char gender = sc.nextLine().charAt(0);
		System.out.print("전화번호: ");
		String Phone = sc.nextLine();
		System.out.print("추가 정보를 더 입력하시겠습니까? (y/n): ");
		char info = sc.nextLine().charAt(0);
		if (info == 'y' || info == 'Y') {
			System.out.print("사원부서: ");
			String dept = sc.nextLine();
			System.out.print("사원연봉: ");
			int salary = sc.nextInt();
			sc.nextLine();
			System.out.print("보너스율: ");
			double bonus = sc.nextDouble();
			sc.nextLine();
			ec.add(empNo, Name, gender, Phone, dept, salary, bonus);
		} else {
			ec.add(empNo, Name, gender, Phone);
		}
	}

	public void updateEmp() {
		System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
		System.out.println("사원의 어떤 정보를 수정하시겠습니까?");// 사원의 어떤 정보를 수정하시겠습니까?
		System.out.println("1. 전화번호");// 1. 전화번호
		System.out.println("2. 사원 연봉");// 2. 사원 연봉
		System.out.println("3. 보너스 율");// 3. 보너스 율
		System.out.println(" 9. 돌아가기");// 9. 돌아가기
		System.out.println("메뉴 번호를 누르세요 : ");// 메뉴 번호를 누르세요 :
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("수정할 전화번호:");
			ec.modify(sc.nextLine());
			sc.nextLine();
		} else if (choice == 2) {
			System.out.println("수정할 사원 연봉:");
			ec.modify(sc.nextInt());
			sc.nextLine();
		} else if (choice == 3) {
			System.out.println("수정할 보너스 율");
			ec.modify(sc.nextDouble());
			sc.nextLine();
		} else if (choice == 9) {
			System.out.println("메인메뉴로 돌아갑니다");
			return;
		} else {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
	}

	public void deleteEmp() {
		System.out.print("정말 삭제하시겠습니까?(y,n)");
		char answer = sc.nextLine().charAt(0);
		if (answer == 'y' || answer == 'Y') {
			if (ec.remove() == null)
				System.out.println("삭제에 성공했습니다");
			else
				System.out.println("삭제에 실패했습니다");
		}
	}

	public void printEmp() {
		if (ec.inform() == null)
			System.out.println("사원 데이터가 없습니다.");
		else
			System.out.println(ec.inform());
	}
}
