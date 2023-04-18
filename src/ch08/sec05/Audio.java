package ch08.sec05;

public class Audio implements RemoteControl {
	//필드
	private int volume;

	//turnOn() 추상 메소드 오버라이딩
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume>MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else if(volume<MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}
	
	//필드
	private int memoryVolume;
	
	//디폴트 메소드 정의
	@Override
	public void setMute(boolean mute) {
		if(mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제합니다.");
			setVolume(this.memoryVolume);
		}
	}
	
	public static void test() {
		System.out.println("fdf");
		
	}
	
}
