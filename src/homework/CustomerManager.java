package homework;

import java.util.Arrays;
import java.util.Scanner;



public class CustomerManager {
    String[] a = {"hi"};
    static String[] b = {"hello"};
    //배열에 저장할 수 있는 최대 고객의 수
    static final int MAX = 100;
    //고객 정보를 저장할 변수 선언;
    static String[] nameList = new String[MAX]; //static을 붙이지 않으면 static 함수에서 값을 사용하지 못함
    static char[] genderList = new char[MAX];
    static String[] emailList = new String[MAX];
    static int[] birthYearList = new int[MAX];

    static int index = -1;
    static int count = 0;

    static Scanner scanner = new Scanner(System.in);

    private static void insertCustomerData(){
        System.out.println("이름: ");
        nameList[count] = scanner.next();
        System.out.println("성별(F/M): ");
        genderList[count] = scanner.next().charAt(0);
        System.out.println("이메일: ");
        emailList[count] = scanner.next();
        System.out.println("출생년도(예 19980409): ");
        birthYearList[count] = scanner.nextInt();
        count++;
    }
    
    private static void printCustomerInfo(){
        System.out.println("=======================CUSTOMER_INFO=======================");
        System.out.println("이름: " + nameList[index]);
        System.out.println("성별: " + genderList[index]);
        System.out.println("이메일: " + emailList[index]);
        System.out.println("출생년도: " + birthYearList[index]);
        System.out.println("=======================CUSTOMER_INFO=======================");
    }
    
    private static void deleteCustomerDate(){
        for(int i = index; i<count-1; i++){
            nameList[i] = nameList[i+1];
            genderList[i] = genderList[i+1];
            emailList[i] = emailList[i+1];
            birthYearList[i] = birthYearList[i+1];
        }
        count--;
    }
    
    private static void updateCustomerData(){
        System.out.println("=======================UPDATE_INFO=======================");
        System.out.println("이름:(" + nameList[index] + ")");
        nameList[index] = scanner.next();
        
        System.out.println("성별:(" + genderList[index] + ")");
        genderList[index] = scanner.next().charAt(0);
        
        System.out.println("이메일:(" + emailList[index] + ")");
        emailList[index] = scanner.next();
        
        System.out.println("출생년도:(" + birthYearList[index] + ")");
        birthYearList[index] = scanner.nextInt();
        
    }
    private static void indexInsertDate(){
        System.out.print("데이터를 저장할 위치를 알려주세요");
        index = Integer.parseInt(scanner.next());
        for(int i=count; i>index; i--){
            nameList[i] = nameList[i-1];
            genderList[i] = genderList[i-1];
            emailList[i] = emailList[i-1];
            birthYearList[i] = birthYearList[i-1];
        }
        System.out.println("이름: ");
        nameList[index] = scanner.next();
        System.out.println("성별(F/M): ");
        genderList[index] = scanner.next().charAt(0);
        System.out.println("이메일: ");
        emailList[index] = scanner.next();
        System.out.println("출생년도(예 19980409): ");
        birthYearList[index] = scanner.nextInt();
        count++;        

    }
    private static void view(){
        for(int i=0; i<count; i++){
            System.out.println("이름: " + nameList[i] + "성별: " + genderList[i] + "이메일: " + emailList[i] + "출생년도" + birthYearList[i]);
        }
    }
    public static void main(String[] args) {
        while(true){
            System.out.printf("\n[INFO] 고객 수: %d, 인덱스: %d\n", count, index);
            System.out.println("메뉴를 입력하세요.");
            System.out.println("(I)nsert, (M)yInsert, (V)iew,(P)revious, (N)ext, (C)urrent, (U)pdate, (D)elete, (Q)uit");
            System.out.print("메뉴 입력: ");
            String menu =scanner.next();
            menu = menu.toLowerCase(); //소문자 변환

            switch(menu.charAt(0)){
                case 'i':
                System.out.println("고객 정보 입력을 시작합니다");
                if(count > MAX){
                    System.out.println("입력을 더 이상 할 수 없습니다.");
                }else{
                    insertCustomerData();
                    System.out.println("고객 정보를 입력했습니다.");
                }
                break;
                case 'm':
                if(count > MAX){
                    System.out.println("입력을 더 이상 할 수 없습니다.");
                }else{
                    indexInsertDate();
                    System.out.println("고객 정보를 입력했습니다.");
                }
                case 'v':
                if(index != -1){
                    view();
                }else{
                    System.out.println("정보가 없습니다.");
                }
                case 'p':
                System.out.println("이전 데이터를 출력합니다.");
                if(index <= 0){
                    System.out.println("이전 데이터가 없습니다.");
                }else{
                    index--;
                    printCustomerInfo();
                }
                break;
                case 'n':
                System.out.println("다음 데이터를 출력합니다.");
                if(index >= count -1){
                    System.out.println("다음 데이터가 없습니다.");
                }else{
                    index++;
                    printCustomerInfo();    
                }
                break;
                case 'c':
                System.out.println("현재 데이터를 출력합니다.");
                if((index >=0) && (index<count)){ //위에서 index >= count-1 때문에 index<count를 안해줘도 될 것 같다. 
                    printCustomerInfo();
                }else{
                    System.out.println("데이터가 선택되지 않습니다.");
                }
                break;
                case 'u':
                System.out.println("데이터를 수정합니다.");
                if((index >=0) && (index<count)){
                    System.out.println(index + "번째 데이터를 수정합니다.");
                    updateCustomerData();
                }else{
                    System.out.println("데이터가 선택되지 않았습니다.");
                }
                break;
                case 'd':
                System.out.println("데이터를 삭제합니다.");
                if((index >=0) && (index<count)){
                    System.out.println(index + "번째 데이터를 삭제합니다.");
                    deleteCustomerDate();
                }else{
                    System.out.println("데이터가 선택되지 않았습니다.");
                }
                break;
                case 'q':
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                System.exit(0); //break를 하면 swtich문만 종료되고 while문은 종료되지 않으니 exit으로 프로그램을 종료한다.
                default:
                System.out.println("메뉴를 잘못 입력했습니다.");
            }
        }        
    }
}

