package ch01.sec06;

public class StringExample {
	public static void main(String[] args) {
		System.out.println(A.a);
		char c1 = '가';
		String name = "홍길동";
		System.out.println(name);
		String str = "나는 \"자바\"를 배웁니다."; // \"는 이스케이프 문자로써 "안에서 "문자를 포함할 수 있음
		String str2 = "나는 \t \"이스케이프 문자\"를 배웁니다."; // \t는 탭
		System.out.println(str);
		System.out.println(str2);
		String str3 = "Hello\rMy"; //캐리지 리턴 때문에 원래 Hello자리에 My가 오게 된다. 그래서 My가 맨 앞에 오고 나머지 llo가 출력됨.
		System.out.println(str3);
		/*
		 Carriage Return은 예전에는 타이프라이터나 프린터와 같은 기계적 장치에서 사용되었습니다. 
		  이 장치에서는 커서가 다음 줄의 맨 앞으로 이동하면서 출력 헤드를 맨 왼쪽으로 이동시킵니다.
		  따라서 Carriage Return을 문자열에 포함시키면 커서가 해당 줄의 맨 앞으로 이동하게 됩니다.
		 */
		
//		String str4 = """
//				"vs코드에선"
//				된당				
//				""";
		/*
			"""은 JDK13 버전에 추가된 기능이지만 egov 3.10에 있는 이클립스는 지원 안함(vscode는 사용 가능)
			프로젝트 설정에서 컴파일러 옵션을 바꿔 preview 기능을 사용할 수 있음. 
		 */
	}
}
class A{
	public static int a;
	static {
		a = 1;
	}
}
