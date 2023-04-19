package ch11.sec05;

public class ThrowsExample2 {
	public static void main(String[] args) throws Exception{
		findClass();
//	main에서 throws처리하면 JVM이 최종적으로 예외 처리를 하는데, 그럼 아래의 코드가 실행되지 않음
		System.out.println("실행");
	}
	
	public static void findClass() throws ClassNotFoundException{
		Class.forName("java.lang.String2");
	}
}
