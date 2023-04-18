package ch03.sec09;

public class BitShiftExample {
	public static void main(String[] args) {
		int pixel = 0xA400A5FF; //red: 0xA4, green: 0, blue: 0xA5
		//red 성분만 출력하고 싶으면,,,
		int red = pixel >>> 24;
		System.out.println(red);
		
		int blue = (pixel >>> 8) & 0x000000FF;
		// 0x00A400A5
		// 0x000000FF &
		// 00000000 101000100 00000000 10101011 
		// 00000000 000000000 00000000 11111111 +
		// 00000000 000000000 00000000 10101011 => 0x000000A5
		
		System.out.println(blue);
		
		byte key = 0b00000100; // 4 
		// 컨트롤키는 4, 알트키 2, 쉬프트키는 1이라는 값을 할당 했다고 가정
		// Key 컨트롤키가 눌려진 것으로 간주
		if(key == 4) {
			System.out.println("컨트롤키");
		}
		byte key2 = 0b00000110; // 6 & 0b00000100을 해야 key2가 컨트롤이 눌린지 알 수 있다.
		if((key2 & 0x04) > 0) {
			System.out.println("컨트롤 키 눌려짐");
		}
		if((key2 & 2) > 0) {
			System.out.println("알트키가 눌려짐");
		}
	}
}
