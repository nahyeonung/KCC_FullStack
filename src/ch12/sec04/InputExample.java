package ch12.sec04;

import java.io.IOException;

public class InputExample {
	public static void main(String[] args) throws IOException {
//		int key = System.in.read();
//		System.out.println(key);
		
		byte[] buffer = new byte[100];
		int readCount = System.in.read(buffer); // \n도 같이 포함해서 들어감 그래서 입력한 개수 +2만큼 반환
		String line = new String(buffer, 0, readCount);
		System.out.println("읽은 데이터 : " + line);
		System.out.println("읽은 바이트 수 : " + readCount);
	}
}
