package ch18;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputExample {
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("text.txt")){
			byte[] buffer = new byte[10];
			int readCount = 0;
//			int data2 = fis.read();
			while(true) {
//				read(byte[] b)에서 입력 스트림으로부터 바이트를 더 이상 읽을 수 없다면 -1을 리턴
				readCount = fis.read(buffer);
				System.out.println(buffer[0]);
				if(readCount <= 0) break;
				System.out.println(new String(buffer, 0, readCount));
			}
//			System.out.println(new String(buffer, 0, readCount));
//			System.out.println(data2);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
