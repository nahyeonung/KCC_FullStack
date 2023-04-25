package homework.generic;

public class ContainExample {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		System.out.println(str);
		
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);
	}
}
class Container<T>{
	T arg;
	
	T get() {
		return arg;
	}
	
	void set(T arg){
		this.arg = arg;
	}
	
}
