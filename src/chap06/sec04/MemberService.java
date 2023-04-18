package chap06.sec04;

public class MemberService {
    boolean login(String id, String password){
        // if(id.equals("hong") && password.equals("12345")){   //id나 password에 null이 들어오면 NullPointException error가 발생!!
        if("hong".equals(id) && "12345".equals(password)){ //변수가 아닌 문자열에 equals함수를 사용하면 NullPointException error 걱정 안해도 됨.
            return true;
        }else{
            return false;
        }
    }

    void logout(String id){
        System.out.println(id+"님이 로그아웃 되었습니다.");
    }
}
