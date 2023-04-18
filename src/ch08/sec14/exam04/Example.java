package ch08.sec14.exam04;

public class Example {
    public static void action(A a){
        System.out.println();
        a.method1();
        if(a instanceof C){
        	C c = (C)a;
            c.method2();
        }
    }

    public static void main(String[] args) {
        action(new B());
        action(new C());
    }
}
