package homework;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        CustomerManager ct1 = new CustomerManager();
        CustomerManager ct2 = new CustomerManager();
        String[] a = ct1.a;
        String[] a2 = ct2.a;
        System.out.println(a);
        System.out.println(a2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a2));
        System.out.println(a == a2);

        String[] b = ct1.b;
        String[] b2 = ct2.b;
        System.out.println(b);
        System.out.println(b2);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(b2));
        System.out.println(b == b2);
    }
}
