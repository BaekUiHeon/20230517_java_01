// 컴파일에러: 프로그램의 실행을 막는 소스상의 문법에러, 소스구문을 수정하여 해결
// 런타임에러: 입력값이 틀렸거나, 배열의 인덱스 범위를 벗어났거나, 계산식의 오류 등 주로 if문 사용으로 에러처리
// 시스템에러: 컴퓨터 오작동으로 인한 에러, 소스 구문으로 해결 불가 


package kh.lclass.io;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileIO {
	
	public void testFile()  {
		File f1= new File("D:/data2/test");
		f1.mkdirs();	 //경로상에 속하는 폴더를 모두 만들어준다. (파일은 만들지 않음)
		File f2=new File("D:/data2/test/aaa.txt"); // 파일 f2를 객체로만 생성함.
		FileWriter fw=null;
		try {
			f2.createNewFile(); // 경로상의 해당 파일을 만들어줌
			
			fw = new FileWriter(f2);
			fw.write("abcdefgss");
			fw.flush();
	//		fw.close();       //close를 try안에두면 안닫히는 경우가 생기므로 try 밖에 두도록 한다.
			return;
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally{
		try {
			if(fw!=null) fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			}
		}//자동완성 
	}
}