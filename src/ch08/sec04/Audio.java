package ch08.sec04;

public class Audio implements RemoteControl {
	//필드
	private int volume;
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
		} else if(volume>MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 볼륨: " + this.volume);
	}
	
}
