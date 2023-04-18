package ch08.sec09;

public class ExtendsExample {
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();

        impl.methodA();
        impl.methodB();
        impl.methodC();
        System.out.println();

        InterfaceA ia = impl;
        ia.methodA();
        // ia.methodB(); //타입 변환되서 안됨
        System.out.println();

        InterfaceB ib = impl;
        // ib.methodA(); //마찬가지로 interfaceB에 methodA가 없기 때문에 안됨
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
