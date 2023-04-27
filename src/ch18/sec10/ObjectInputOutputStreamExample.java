package ch18.sec10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//FileOutputStream에 ObjectOutputStream 보조 스트림 연결
		FileOutputStream fos = new FileOutputStream("Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//객체 생성
		Member m1 = new Member("fall", "단풍이");
		int[] arr1 = {1,2,3};
		
		//객체를 직렬화해서 파일에 저장
		oos.writeObject(m1);
		oos.writeObject(arr1);
		
		oos.flush(); oos.close(); fos.close();
		
		//FileInputStream에 ObjectInputStream 보조 스트림 연결
		FileInputStream fis = new FileInputStream("Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//파일을 읽고 역직렬호해서 객체로 복원
		Member m2 = (Member) ois.readObject();
		int[] arr2 = (int[]) ois.readObject();
		ois.close(); fis.close();
		
		//복원된 객체 내용 확인
		System.out.println(m2);
		System.out.println(Arrays.toString(arr2));
	}
}
@AllArgsConstructor @ToString
class Member implements Serializable{
	private static final long serialVersionUID = -653356464L;
	private String id;
	private String name;
}
