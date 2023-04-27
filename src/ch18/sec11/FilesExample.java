package ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
	public static void main(String[] args) {
		try {
			String data = ""+
					"id: winter\n"+
					"email: abcd@naver.com"+
					"tel: 010-1234-5678";
			//Path 객체 생성(readString메서드의 매개변수로 Path객체가 와야하기 때문에 생성)
			Path path = Paths.get("C:/user.txt"); 
			
			//파일 생성 및 데이터 저장
			Files.writeString(Paths.get("C:/user.txt"), data, Charset.forName("UTF-8"));
			
			//파일 정보 얻기
			System.out.println("파일 유형: " + Files.probeContentType(path));
			System.out.println("파일 크기: " + Files.size(path) + " bytes");
			
			//파일 읽기
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
