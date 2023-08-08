import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Hello {
	File file= new File("D:\\data2\\a.txt");
	public void creatFileTest(){
	try{
	file.createNewFile();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
		
	try(BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));)
	{bw.write("Hello Wrold");}
		
	catch(NullPointerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
