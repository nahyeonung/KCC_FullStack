package ch05.sec12;

import java.util.Calendar;
import java.util.Date;

public class CalendarExample {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        Date now2 = new Date();
        System.out.println(now2);
        System.out.println(now == now2); //객체가 새로 생성됨
        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        System.out.println(cal == cal2); 
        
    }    
}
