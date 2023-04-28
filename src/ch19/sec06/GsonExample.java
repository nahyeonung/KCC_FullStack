package ch19.sec06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class GsonExample {
	public static void main(String[] args) throws IOException {
		List<Member> memberList = new ArrayList<>();
		memberList.add(new Member("홍길동", 20, 3000.0, "hong@hong.com"));
		memberList.add(new Member("홍길서", 22, 6000.0, "kil@hong.com"));
		memberList.add(new Member("홍길남", 21, 4000.0, "south@hong.com"));
		Gson gson = new Gson();
		String json = gson.toJson(memberList);
//		System.out.println(json);
		Map<String, String> map = new HashMap<String, String>();
		map.put("a","a1");
		map.put("b","a2");
		String jsonMap = gson.toJson(map);
//		System.out.println(jsonMap);
		
        // Json key, value 추가
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", "한겨울");
        jsonObject.addProperty("id", "winter");
        jsonObject.addProperty("student", true);
        jsonObject.addProperty("age", 25);
 
        JsonObject leaf = new JsonObject();
        leaf.addProperty("home", "02-123-1234");
        leaf.addProperty("mobile", "010-123-1234");
        jsonObject.add("tel", leaf);
        // JsonObject를 Json 문자열로 변환
        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);
		
		Writer writer = new FileWriter("textGson.json", Charset.forName("UTF-8"));
		writer.write(jsonStr);
		writer.flush();
		writer.close();
	}
}
@AllArgsConstructor
@Getter @Setter @ToString
class Member{
	private String name;
	private int age;
	private double salary;
	private String email;
	
	public String toJSON() {
		return "{ \"name\": " + name + ", \"age\": "+ age + "}";
	}
}