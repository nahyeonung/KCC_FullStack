package testPage;

public class chapFourPractice {
	public static void main(String[] args) {
//		for(int x=0; x<11; x++) {
//			for(int y=0; y<=11; y++) {
//				if(4*x + 5*y == 60) {
//					System.out.printf("(%d,%d)\n", x, y);
//				}
//			}
//		}
		for(int i=1; i<=5; i++) {
			for(int j=5-i; j>=1; j--) {
				System.out.print(" ");
			}
			System.out.println("*".repeat(i));
		}
		
		for(int i=1; i<=5; i++) {
			for(int j=5-i; j>=1; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
