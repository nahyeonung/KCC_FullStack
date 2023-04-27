package homework.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class MemberIOExample {
	public static void main(String[] args) {
		List<Member> memberList = new ArrayList<>();
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("member.data");
			dis = new DataInputStream(fis);
			while(true) {
				//available() :현재 읽을 수 있는 바이트 수를 반환한다.
				if(dis.available()<=0) break;
				String name = dis.readUTF();
				if(name == null || name.trim().length()==0) {
					break;
				}
				int age = dis.readInt();
				double salary = dis.readDouble();
				String email = dis.readUTF();
				//쓸데없이 들어있는 공백을 처리하기 위해 trim()
				if(name==null || name.trim().length() == 0) { 
					break;
				}
				System.out.println(name + age + salary + email);
				memberList.add(new Member(name, age, salary, email));
			}
			System.out.println(memberList.size());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {dis.close(); fis.close();}catch(Exception e) {};
		}
//		memberList.add(new Member("홍길동", 20, 30000, "hong@hong.com"));
//		memberList.add(new Member("홍길서", 22, 20000, "hong@hong.com"));
//		memberList.add(new Member("홍길남", 28, 35000.2, "hong@hong.com"));
//		FileOutputStream fos = null;
//		DataOutputStream out = null;
//		try {
//			fos = new FileOutputStream("member.data");
//			out = new DataOutputStream(fos);
//			for(Member m: memberList) {
//				out.writeUTF(m.getName());
//				out.writeInt(m.getAge());
//				out.writeDouble(m.getSalary());
//				out.writeUTF(m.getEmail());
//			}
//			System.out.println("File saved");
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//		}finally {
//			try {out.close();} catch(Exception e){}
//		}
	}
}

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString
class Member{
	private String name;
	private int age;
	private double salary;
	private String email;
	public String toCSV() {
		return name + "," + age + "," + salary + "," + email;
	}
}
