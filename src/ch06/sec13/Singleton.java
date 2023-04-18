package ch06.sec13;

public class Singleton {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static Singleton instance = new Singleton(); //하나의 객체만 생성

    private Singleton(){} //생성을 막음

    public static Singleton getInstance(){
        return instance;
    }

}
