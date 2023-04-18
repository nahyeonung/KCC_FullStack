package ch04.sec08;

public class ContinueExample {
	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			if(i%2 != 0) {
				continue;
			}
			System.out.println(i + " ");
		}
		
		String grade = "B";
		int score1 = switch(grade) {
		case "A" -> 100;
		case "B" -> {
			int result = 10 - 20;
			yield result;
		}
		default -> 60;
		};
		System.out.println(score1);
	}
}
