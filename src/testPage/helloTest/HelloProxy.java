package testPage.helloTest;

public class HelloProxy {
	class Hello{
		public void sayHello(String name) {
			System.out.println("Hello~~" + name);
		}	
	}
//	@Override
	public void sayHello(String name) {
		HelloLog.log();
		Hello hello = new Hello();
		hello.sayHello(name);
	}
}
