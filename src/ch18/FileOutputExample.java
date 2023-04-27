package ch18;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputExample {
	public static void main(String[] args) {
		//데이터를 저장하려면..
		//1. 노드를 무엇으로 할 것인가? File
		//2. 입출력 단위는? byte단위
		//FileOutputStream 클래스를 사용해야 함
		FileOutputStream fos = null;
		try {
			//text.txt를 불러오는 것이 아니라 생성하는 것이기 때문에 덮어쓰기가 된다.
			fos = new FileOutputStream("text.txt");
			byte[] data = {'A', 'B', 'C', 'D', 'E'};
			fos.write(data);
//			fos.write('B');
			fos.flush();
			System.out.println("파일에 데이터 기록됨");
		}catch(IOException e) {
			System.out.println(e.getMessage());	
		}finally {
			try{fos.close();}catch(Exception e) {}
		}
	}
}
