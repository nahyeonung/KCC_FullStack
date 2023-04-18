package ch05.sec12;

import java.util.Calendar;

public class WeekExample {
    public static void main(String[] args) {
        //Week 열거 타입 변수 선언
        Week today = null;

        //Calendar 얻기
        Calendar cal = Calendar.getInstance(); // 싱글톤 객체로 받아오려고 해서 getInstance사용 근데 Calendar는 싱글톤 객체가 아니여서 객체마다 다른 주소값을 가짐
        Calendar cal2 = Calendar.getInstance(); 
        System.out.println(cal == cal2); //그래서 false가 나옴

        //오늘의 요일 얻기(1~7)
        int week = cal.get(Calendar.DAY_OF_WEEK); //오늘 요일을 숫자(1~7)로 반환
        //숫자를 열거 상수로 변환해서 변수에 대입
        switch(week){
            case 1: today = Week.SUNDAY; break;
            case 2: today = Week.MONDAY; break;
            case 3: today = Week.TUESDAY; break;
            case 4: today = Week.WEDNESDAY; break;
            case 5: today = Week.FRIDAY; break;
            case 6: today = Week.SATURDAY; break;
            case 7: today = Week.SUNDAY; break;
        }
        //열거 타입 변수를 사용
        if(today == Week.SUNDAY){
            System.out.println("일요일에는 축구를 합니다.");
        }else{
            System.out.println("열심히 자바를 공부합니다.");
        }
    }
}
