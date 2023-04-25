package ch14;

public class CounterRunner implements Runnable {
	@Override
	public void run() {
		for(int i=30; i>0; i--) {
			if(FlagData.isOK) {
				System.out.println("정답-폭탄해체됨");
				return; //메서드를 종료시키려면 리턴을 시켜버리면 됨.
			}
			if(FlagData.isFail) {
				System.out.println("3번의 기회를 다 날렸습니다.");
				break;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
		System.out.println("빵");
		System.exit(0);
	}
}
