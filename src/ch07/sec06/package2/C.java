package ch07.sec06.package2;

import ch07.sec06.package1.*;

public class C {

    //A와 C는 다른 패키지에 있기 때문에 A의 protected 필드, 생성자, 메소드에 접근할 수 없다.(상속은 다른 패키지여도 가능)
    // A a = new A();
    // a.field = "Value";
    // a.method();    
}
