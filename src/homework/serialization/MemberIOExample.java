package homework.serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class MemberIOExample {
	public static void main(String[] args) throws ClassNotFoundException {
		List<Member> memberList = new ArrayList<>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("member.ser");
			ois = new ObjectInputStream(fis);
			memberList = (List<Member>)ois.readObject();
			System.out.println(memberList.size());
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try{fis.close(); ois.close();}catch(Exception e) {}
		}
//		memberList.add(new Member("홍길동", 20, 30000, "hong@hong.com"));
//		memberList.add(new Member("홍길서", 22, 20000, "hong@hong.com"));
//		memberList.add(new Member("홍길남", 28, 35000.2, "hong@hong.com"));
//		ObjectOutputStream oos = null;
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream("member.ser");
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(memberList);
//			System.out.println("data saved");
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
	}
}

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString
class Member implements Serializable{
	private String name;
	private int age;
	private double salary;
	private String email;
	public String toCSV() {
		return name + "," + age + "," + salary + "," + email;
	}
}
