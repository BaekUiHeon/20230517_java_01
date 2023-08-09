package kh;

import java.util.Scanner;

public class Tree {

	public static void main(String[] args) {
		
		int count,space;
		Scanner sc=new Scanner(System.in);
		System.out.print("정수입력:");                //정수입력
		
		count=sc.nextInt();   // 줄수를 저장
		
		for(int i=1;i<=count;i++) {          // 지역변수 i를 선언하고 count만큼 반복 
			
			for(int j=0;j<count-i;j++){        // count에서 i를 뺀만큼 공백출력
				System.out.print(" ");      
			}
			
			for(int j=0;j<i*2-1;j++)          // i가 증가함에 따라 별갯수를 증가시키면서 출력
				System.out.print("*");
			
			System.out.println();
		}
		
		for(int i=1; i<count; i++) {   //  위에서는 count만큼 반복했으므로, 남은 count-1만큼 반복하겠다. 
			
			for(int j=0;j<i;j++) {            //i만큼 공백출력
				System.out.print(" ");
			}
			
			for(int j=0;j<2*count-1-2*i;j++) {            //count-2i만큼 별을출력 
				System.out.print("*");
			}
			System.out.println();
		
		
		}
	}
}



