package homework.generic;

public class ContainerExample2 {
	public static void main(String[] args) {
		Container2<String, String> container1 = new Container2<>();
		container1.set("홍길동","도적");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1 + job);
		
		Container2<String, Integer> container2 = new Container2<>();
		container2.set("홍길동", 30);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2 + age);
		
	}
}
class Container2<K,M>{
	K name;
	M random;
	
	public void set(K name, M random) {
		this.name = name;
		this.random = random;
	}
	
	public K getKey() {
		return name; 
	}
	
	public M getValue() {
		return random;
	}
}