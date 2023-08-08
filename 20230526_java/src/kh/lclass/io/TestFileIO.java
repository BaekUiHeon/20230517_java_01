// 컴파일에러: 프로그램의 실행을 막는 소스상의 문법에러, 소스구문을 수정하여 해결
// 런타임에러: 입력값이 틀렸거나, 배열의 인덱스 범위를 벗어났거나, 계산식의 오류 등 주로 if문 사용으로 에러처리
// 시스템에러: 컴퓨터 오작동으로 인한 에러, 소스 구문으로 해결 불가 

package kh.lclass.io;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kh.lclass.exception.UserException;
import kh.lclass.oop.sample.Person;



public class TestFileIO {
	public void testFileIntputStreamObject() {
		String filePath="D:/data2/test/aaa.txt";
		FileInputStream ios=null;
		ObjectInputStream ois=null;
		try {
			ios=new FileInputStream(filePath);
			ois=new ObjectInputStream(ios);
			Person a=(Person)(ois.readObject());
			Person b=(Person)(ois.readObject());
			System.out.println(a);
			System.out.println(b);
			}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ios!=null) ios.close();
				if(ois!=null) ois.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public void testFileOutputStreamObject() {
		Person p1= new Person("홍길동",23,'남',10);
		Person p2= new Person("영희",27,'F',18);
		
		String filePath="D:/data2/test/aaa.txt";
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try {
			fos=new FileOutputStream(filePath);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(p1); 
			oos.writeObject(p2);
			oos.flush();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(oos!=null) oos.close();
				if(fos!=null) fos.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	
	public void testFileReadData() {
		String filePath="D:/data2/test/aaa.txt";
		try(  DataInputStream dis= new DataInputStream(new FileInputStream(filePath));  ) 
		{
			Long temp=0L;
			while((temp=dis.readLong())!=0) {
				System.out.println(String.valueOf(temp));
			}
			dis.readLong();
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void testFileRead3() {
		String filePath="D:/data2/test/aaa.txt";
		try (
			FileInputStream fis=new FileInputStream(filePath);  // 기반스트림
			InputStreamReader isr= new InputStreamReader(fis);    // 보조스트림 
			BufferedReader br= new BufferedReader(isr);
		)
		{
			String str=null;
			while((str=br.readLine())!=null)
					System.out.println(str);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testRamda() throws UserException {
		int[] arr= {2,3,4};
		int[] arr2=new int[] {2,3,4};
		for(int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
		}
		throw new UserException();
	}
	public void testFileRead2() {
		String filePath="D:/data2/test/aaa.txt";
		FileInputStream fis=null;
		InputStreamReader isr=null; //보조스트림 1
		BufferedReader br=null;    //보조 스트림 2
		try {
			fis=new FileInputStream(filePath);  // 기반스트림
			isr= new InputStreamReader(fis);    // 보조스트림 
			br= new BufferedReader(isr);
//			isr= new InputStreamReader(new FileInputStream(filePath)); // 생략을 통해 한번에 선언한 보조스트림  
//			br= new BufferedReader(new InputStreamReader(new FileInputStream(filePath))); //생략을 통해 선언한 보조스트림
			String str=null;
			while((str=br.readLine())!=null)
				System.out.println(str);
				
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fis!=null) fis.close();  // 1. 보조스트림 닫고
				if(isr!=null) isr.close();  // 2. 기반스트림 닫음
				if(br!=null) br.close();
			}
			catch(IOException e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public void testFileRead() { //InputStream
		String filePath="D:/data2/test/aaa.txt";
		FileReader fr = null;
		try {
		fr=new FileReader(filePath);
		try {
//			while((a=fr.read()) > -1)
//			System.out.print((char)a);
			char[] readCharArr=new char[600];
			for(int i=0; i<readCharArr.length/50; i++) {
				int readCnt=fr.read(readCharArr,i*50,50);
				if(readCnt==-1)
					break;
				System.out.println(readCnt);
			}
			System.out.println(readCharArr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을수 없습니다. 경로를 확인해주세요.");
		}
		finally {
			try {if(fr!=null) fr.close(); }
			catch(IOException e){e.printStackTrace();}
		}
	}
	
	
	
	public void testFile()  {                               //폴더 생성, 파일생성, OutputStream
		File f1= new File("D:/data2/test");
		f1.mkdirs();	 //경로상에 속하는 폴더를 모두 만들어준다. (파일은 만들지 않음)
		File f2=new File("D:/data2/test/aaa.txt"); // 파일 f2를 객체로만 생성함. 또는 new File(경로,파일명)
		FileWriter fw=null;
		try {
			f2.createNewFile(); // 경로상의 해당 파일을 만들어줌
			
			fw = new FileWriter(f2);  // File에 문자형태 전송이 가능한 OutputStream
			fw.write("import java.io.File;\r\n"
					+ "import java.io.FileNotFoundException;\r\n"
					+ "import java.io.FileReader;\r\n"
					+ "import java.io.FileWriter;\r\n"
					+ "import java.io.IOException;\r\n"
					+ "\r\n"
					+ "public class TestFileIO {\r\n"
					+ "	public void testFileRead() { //InputStream\r\n"
					+ "		String filePath=\"D:/data2/test/aaa.txt\";\r\n"
					+ "		FileReader fr = null;\r\n"
					+ "		try {\r\n"
					+ "		fr=new FileReader(filePath);\r\n"
					+ "		try {\r\n"
					+ "//			while((a=fr.read()) > -1)\r\n"
					+ "//			System.out.print((char)a);\r\n"
					+ "			char[] readCharArr=new char[600];\r\n"
					+ "			for(int i=0; i<readCharArr.length/50; i++) {\r\n"
					+ "				int readCnt=fr.read(readCharArr,i*50,50)"); // 전송하고자 하는 문자 작성
			fw.flush(); // OutputStream(버퍼)에 존재하는 데이터를 보조기억장치로 모두 보냄.
	//		fw.close();       //close를 try안에두면 안닫히는 경우가 생기므로 try 밖에 두도록 한다.
			return;
		} catch(IOException e) {
			e.printStackTrace();
		}
		finally{
		try {
			if(fw!=null) fw.close(); // OutputStream 버퍼닫기 
		}
		catch(IOException e) {
			e.printStackTrace();
			}
		}//자동완성 
	}
}
