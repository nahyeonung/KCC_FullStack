package ch16.sec05.exam02;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		
//		person.ordering((a,b) -> a.compareToIgnoreCase(b)); 아래 코드와 같은 내용
		person.ordering(String :: compareToIgnoreCase);
	}
}
