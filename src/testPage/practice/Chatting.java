package testPage.practice;

public class Chatting {
	class Chat{
		void start() {}
		void sendMessage(String message){}
	}
	
	void startChat(String chatId) {
		final String nickName = chatId;
//		nickName = chatId;
		
		Chat chat = new Chat() {
			@Override
			public void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
}
