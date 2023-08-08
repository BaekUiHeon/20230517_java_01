package funcpractice;

public class Practice {
	public static void main(String[] args) {
	
		String str="Hello Java";
		String subStr1;
		String subStr2;
		System.out.println("안"+2*4);
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		String strReplace = str.replace('a','e');
		System.out.println(strReplace.toLowerCase());
		
		subStr1=str.substring(6);    //6부터 저장 
		System.out.println(subStr1);
		subStr2=str.substring(0,5);  //0부터 4까지 저장
		System.out.println(subStr2);
		
		System.out.println(str.indexOf('J'));
	}
}
