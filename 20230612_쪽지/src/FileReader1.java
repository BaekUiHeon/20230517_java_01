import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReader1 {
	public void FileReaderTest() {
		String fileName="D:\\data2\\a.txt";
		String forR=null;
		try(
				BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
				){
			forR=br.readLine();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println(forR);
		}
		
	}
}
