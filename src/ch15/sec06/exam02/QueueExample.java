package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		//Queue 컬랙션 생성
		Queue<Message> messageQueue = new LinkedList<>();
		
		//메시지 넣기
		//offer(E e): 주어진 객체를 큐에 넣는다.
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "신용권"));
		messageQueue.offer(new Message("sendKakaotalk", "감자바"));
		
		//메시지를 하나씩 꺼내어 처리
		//poll() 큐에서 객체를 빼낸다.
		while(!messageQueue.isEmpty()) {
			//선입선출(FIFO)으로 꺼냄
			Message message = messageQueue.poll();
			switch(message.command) {
			case "sendMail":
				System.out.println(message.to + "님에게 메일을 보냅니다.");
				break;
			case "sendSMS":
				System.out.println(message.to + "님에게 SMS를 보냅니다.");
				break;
			case "sendKakaotalk":
				System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
				break;
			}
		}
		
	}
}
