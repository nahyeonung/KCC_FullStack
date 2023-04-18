package ch06.sec13.exam;

import java.util.Arrays;
import java.util.Scanner;



public class CustomerManager {
    String[] a = {"hi"};
    static String[] b = {"hello"};
    //배열에 저장할 수 있는 최대 고객의 수
    static final int MAX = 100;
    //고객 정보를 저장할 변수 선언;
    // static String[] custList = new String[MAX]; //static을 붙이지 않으면 static 함수에서 값을 사용하지 못함
    // static char[] custList = new char[MAX];
    // static String[] emailList = new String[MAX];
    // static int[] birthYearList = new int[MAX];

    static Customer[] custList = new Customer[MAX];
    

    static int index = -1;
    static int count = 0;
    
    static Scanner scanner = new Scanner(System.in);
    
    private static void insertCustomerData(){
        Customer cust = new Customer();
        System.out.println("이름: ");
        cust.setName(scanner.next());
        System.out.println("성별(F/M): ");
        cust.setGender(scanner.next().charAt(0));
        System.out.println("이메일: ");
        cust.setEmail(scanner.next());
        System.out.println("출생년도(예 19980409): ");
        cust.setBirthYear(scanner.nextInt());
        custList[count++] = cust;
        System.out.println(Arrays.toString(custList));
    }
    
    private static void printCustomerInfo(){
        Customer cust = custList[index];
        System.out.println("=======================CUSTOMER_INFO=======================");
        System.out.println("이름: " + cust.getName());
        System.out.println("성별: " + cust.getGender());
        System.out.println("이메일: " + cust.getEmail());
        System.out.println("출생년도: " + cust.getBirthYear());
        System.out.println("=======================CUSTOMER_INFO=======================");
    }
    
    private static void deleteCustomerDate(){
        for(int i = index; i<count-1; i++){
            custList[i].setName(custList[i+1].getName());
            custList[i].setGender(custList[i+1].getGender());
            custList[i].setEmail(custList[i+1].getEmail());
            custList[i].setBirthYear(custList[i+1].getBirthYear());
        }
        count--;
    }
    
    private static void updateCustomerData(){
        Customer cust = custList[index];
        System.out.println("=======================UPDATE_INFO=======================");
        System.out.println("이름:(" + cust.getName() + ")");
        cust.setName(scanner.next());
        
        System.out.println("성별:(" + cust.getGender() + ")");
        cust.setGender(scanner.next().charAt(0));
        
        System.out.println("이메일:(" + cust.getEmail() + ")");
        cust.setEmail(scanner.next());
        
        System.out.println("출생년도:(" + cust.getBirthYear() + ")");
        cust.setBirthYear(scanner.nextInt());
        
    }
    private static void indexInsertDate(){
        System.out.print("데이터를 저장할 위치를 알려주세요");
        index = Integer.parseInt(scanner.next());
        //custList는 Customer를 담는 배열이지만 값이 넣기 전까진 null이기 때문에 custList[count].setName()같은 걸 할 수 없다. 
        //custList[count]은 Customer 객체가 담기지 않고 null이 담겨 있으니까!!
        for(int i=count; i>index; i--){
            custList[i] = custList[i-1]; 
        }
        Customer cust = new Customer();
        System.out.println("이름: ");
        cust.setName(scanner.next());
        System.out.println("성별(F/M): ");
        cust.setGender(scanner.next().charAt(0));
        System.out.println("이메일: ");
        cust.setEmail(scanner.next());
        System.out.println("출생년도(예 19980409): ");
        cust.setBirthYear(scanner.nextInt());
        custList[index] = cust;
        count++;   

    }
    private static void view(){
        for(int i=0; i<count; i++){
            System.out.println("이름: " + custList[i].getName() + "성별: " + custList[i].getGender() 
            + "이메일: " + custList[i].getEmail() + "출생년도" + custList[i].getBirthYear());
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
                break;
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

