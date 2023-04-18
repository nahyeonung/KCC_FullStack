package ch08;

public interface RemoteControl {
	int DEFAULT = 10; //italic채에 진하게 됨(interface의 필드에는 public static final이 자동으로 붙기 때문)
	void turnOn(); //public abstract
}
class A{
	int hello;
	static int hello2 = 10;
	static final int hello3 = 30;
}
