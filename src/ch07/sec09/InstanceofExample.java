package ch07.sec09;


public class InstanceofExample {
    //main() 메소드에서 바로 호출하기 위해 정적 메소드 선언
    public static void personInfo(Person person){
        System.out.println("name: " + person.name);
        person.walk();
        if(person instanceof Student){
        	Student student = (Student)person;
            System.out.println("studentNo: " + student.studentNo);
            student.study();
        }
    }

    public static void main(String[] args) {
        //Person 객체를 매개값으로 제공하고 personInfo() 메소드 호출
        Person p1 = new Person("홍길동");
        personInfo(p1);

        System.out.println();
        //Student 객체를 매개값으로 제공하고 personInfo() 메소드 호출
        Person p2 = new Student("김길동" , 10);
        // p2.study(); 부모클래스의 틀에 객체를 담았기 때문에 자식 클래스에서 선언한 메소드는 사용 불가
        personInfo(p2);

        Student s1 = new Student("나현웅", 1);
        s1.study();
        personInfo(s1);

        Student ss = new Student("ㅇㄹ", 0);

    }
}
