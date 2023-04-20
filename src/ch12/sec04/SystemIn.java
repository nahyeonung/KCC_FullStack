package ch12.sec04;

import java.io.IOException;

public class SystemIn {
	public static void main(String[] args) throws IOException {
		byte[] buffer = new byte[100];
		int readCount = System.in.read(buffer);
		//String클래스는 String(byte[] bytes, int offset, int length) 생성자를 가지고 있음
		String line = new String(buffer, 0, readCount);
		System.out.println("읽은 데이터: " + line);
		System.out.println("읽은 바이트 수: " + readCount);

	}
}
