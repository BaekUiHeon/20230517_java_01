import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BubbleSort {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		
		System.out.println(a);
		System.out.println(b);
		
		String[] stArr= {"김종호","박범계","이재명","엄준식","김남국","홍준표","나선욱"};	
		String tmp=null;
		for(int i=0;i<stArr.length-1;i++) {
			for (int j=0;j<stArr.length-i-1;j++)
				if(stArr[j].compareTo(stArr[j+1])>1) {
					tmp=stArr[j];
					stArr[j]=stArr[j+1];
					stArr[j+1]=tmp;
				}			
		}
		System.out.println(Arrays.toString(stArr));
		
		List<String> list=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.print(",로 구분해서 이름을 입력해주세요:");
		String names=sc.nextLine();
		StringTokenizer tokenizer=new StringTokenizer(names,",");
		while(tokenizer.hasMoreTokens())
			list.add(tokenizer.nextToken());
		Collections.sort(list);
		System.out.println(list);
		sc.close();	
	}
}
