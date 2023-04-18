package ch02.sec10;

public class PrimitiveAndStringConversionExample {
	public static void main(String[] args) {
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1 :" + value1);
		System.out.printf("value2 : %f \n", value2);
		System.out.printf("value3 : %s \n", value3);
		
		// 형식 문자에 d, f, s외에도 c(문자), t(날짜/시간) 도 있습니다.
		// arg_index$는 형식 문자에 매핑되는 변수의 순서를 지정합니다.
		System.out.println();
		java.util.Date d = new java.util.Date();
		System.out.println(d);
		System.out.printf("%ty \n", d); // 연도 출력
		System.out.printf("%tm \n",d); // 월 출력
		//연 월 일을 출력하려면?
		System.out.printf("%ty-%tm-%td \n", d,d,d);
		System.out.printf("%1$ty-%1$tm-%1$td \n",d); //1$는 argument_index로 첫번쨰(1)의 위치에 있는 변수를 가져다 표시하겠다는 의미.
		
	}
}
