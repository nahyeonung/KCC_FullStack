package ch06.sec13;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        s1.setAge(15);
        System.out.println(s1.getAge());
        System.out.println(s2.getAge());
    }
}
