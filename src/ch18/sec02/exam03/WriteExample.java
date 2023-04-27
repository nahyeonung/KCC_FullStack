package ch18.sec02.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("text.txt");
			
			byte[] array = {'h','a','p','p','y'};
			
			os.write(array, 1, 3);
			
			os.flush();
			os.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
