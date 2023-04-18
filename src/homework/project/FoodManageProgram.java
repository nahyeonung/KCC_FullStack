package homework.project;

import java.util.Arrays;
import java.util.Scanner;

import java.util.InputMismatchException;
/*
식자재 관리 프로그램은 식자재 정보를 추가, 목록보기, 수정, 삭제할 수 있는 기능
이 있어야 합니다. 정보를 파일에 저장하는 기능은 구현하지 않아도 됩니다. 메뉴가 1이면 식자재 정보를 입력받도록 하며, 저장된 식자재 정보는 메뉴 2를 입
력해 목록으로 조회할 수 있어야 합니다. 메뉴 3은 식자재 이름으로 조회하여 수량
을 수정합니다. 수정 시 식자재의 수량이 0이면 삭제되어야 합니다. 메뉴 4는 식자
재 정보를 삭제합니다. 삭제 시 이름으로 조회하여 삭제합니다. 프로그램의 종료는 
메뉴 0입니다.
 */
public class FoodManageProgram {
    private static final int MAX = 100;

    static Scanner scan = new Scanner(System.in);
    static Food[] foodList = new Food[MAX];
    // static Food fd = new Food(); //배열에 다른 값을 가지는 객체들이 들어가야하기 때문에 얘는 static으로 하면 안됨
    //homework.project.Food@7ef20235, homework.project.Food@7ef20235 이렇게 배열에 같은 객체가 참조됨.
    static int count = 0;
    static int index = -1;

    public static void insertData(){
        Food fd = new Food();
        System.out.print("음식명을 입력하세요");
        fd.setFoodName(scan.nextLine());
        System.out.print("수량을 입력하세요");
        fd.setFoodCount(scan.nextInt());
        scan.nextLine();
        System.out.print("유통기한을 입력하세요");
        fd.setExpiration(scan.nextLine());
        System.out.print("식자재 설명을 입력하세요");
        fd.setDescription(scan.nextLine());
        foodList[count++] = fd;
        System.out.println(Arrays.toString(foodList));
    }

    public static void viewData(){
        System.out.println("========================음식정보========================");
        for(int i=0; i<count; i++){
            System.out.println(i);
            System.out.println("음식명: " + foodList[i].getFoodName());
            System.out.println("수량: " + foodList[i].getFoodCount());
            System.out.println("유통기한: " + foodList[i].getExpiration());
            System.out.println("식자재 설명: " + foodList[i].getDescription());
            System.out.println("================================================");
        }
        System.out.println("========================음식정보========================");
    }

    public static void updateDate(){
        System.out.println("수정하고 싶은 음식 이름을 입력하세요");
        String name = scan.nextLine();
        int cnt = 0;
        for(int i=0; i<count; i++){
            String realName = foodList[i].getFoodName();
            if(realName.equals(name)){
                cnt++;
                System.out.print("음식명을 입력하세요");
                foodList[i].setFoodName(scan.nextLine());
                System.out.print("수량을 입력하세요");
                foodList[i].setFoodCount(scan.nextInt());
                scan.nextLine();
                System.out.print("유통기한을 입력하세요");
                foodList[i].setExpiration(scan.nextLine());
                System.out.print("식자재 설명을 입력하세요");
                foodList[i].setDescription(scan.nextLine());
                break;
            }
        }
        if(cnt == 0){
            System.out.println("그런 이름을 가진 음식은 존재하지 않습니다.");
        }
    }

    public static void deleteData(){
        System.out.println("삭제하고 싶은 음식의 이름을 적으시오");
        String name = scan.nextLine();
        int cnt = 0;
        for(int i=0; i<count; i++){
            String realName = foodList[i].getFoodName();
            if(realName.equals(name)){
                index = i;
                for(int j=index; j<count-1; j++){
                    foodList[j] = foodList[j+1];
                }
                count--;
                cnt++;
                break;
            }
        }
        if(cnt == 0){
            System.out.println("그런 이름을 가진 음식은 존재하지 않습니다.");
        }

    }


    public static void main(String[] args) {
        while(true){
            System.out.printf("\n[INFO] 음식 수: %d, 인덱스: %d\n", count, index);
            System.out.println("메뉴를 입력하세요.");
            System.out.println("(1)Insert, (2)View,(3)Update, (4)Delete, 종료는 아무 버튼이나");
            System.out.print("메뉴 입력: ");
            try{
                int choose = scan.nextInt();
                scan.nextLine();
                switch(choose){
                    case 1:
                    if(count < MAX){
                        insertData();
                    }else{
                        System.out.println("데이터가 가득 찼습니다. 지우고 다시 시도하세요.");
                    }
                    break;
                    case 2:
                    if(count != 0){
                        viewData();
                    }else{
                        System.out.println("입력될 데이터가 없습니다.");
                    }
                    break;
                    case 3:
                    updateDate();
                    break;
                    case 4:
                    deleteData();
                    break;
                    default:
                    System.out.println("프로그램을 종료합니다.");
                    scan.close();
                    System.exit(0); //break를 하면 swtich문만 종료되고 while문은 종료되지 않으니 exit으로 프로그램을 종료한다.
                }
            } catch(InputMismatchException e){
                System.out.println("문자말고 정수 입력하자");
            }
        }
    }
}
