package homework;

import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class ManageProgram {
    public static void main(String[] args) {
        //이 예제는 점수를 저장하는 배열을 생성합니다.
        int[] array = new int[10];
        //배열의 인덱스 초기값은 -1임, 0은 맨 처음 위치를 의미함
        int index = -1;
        //배열에 저장된 데이터의 개수를 저장할 변수, 초기값은 0;
        int count = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("******************배열 관리 프로그램******************");
        while(true){
            System.out.println("****************************************************");
            System.out.println("1.추가 | 2.출력 | 3.조회 | 4.수정 | 5.삭제 | 6.삽입 | 0.종료");
            System.out.println("****************************************************");
            System.out.print("메뉴: ");
            int menu = scan.nextInt();

            switch(menu){
                case 1:
                System.out.println("배열에 추가할 데이터: ");
                int inputData = scan.nextInt();
                array[count] = inputData;
                count++;
                break;
                
                case 2:
                System.out.println("배열에 데이터를 출력합니다.");
                for(int i=0; i<count; i++){
                    System.out.println(array[i] + "\t");
                }
                System.out.println();
                break;

                case 3:
                System.out.println("배열에서 찾을 데이터");
                int searchData = scan.nextInt();
                for(int i=0; i<count; i++){
                    if(array[i] == searchData){
                        System.out.println(i + "번째에서 데이터를 찾음");
                    }else{
                        System.out.println("nothing to have");
                    }
                }
                break;
                case 4:
                System.out.println("수정할 위치와 데이터 입력(예)2 30): ");
                index = scan.nextInt();
                int updateData = scan.nextInt();
                array[index] = updateData;
                break;

                case 5:
                System.out.println("삭제할 위치 입력: ");
                index = scan.nextInt();
                int deleteData = array[index];
                for(int i=index; i<count-1; i++){
                    array[index] = array[index+1];
                }
                count--;
                break;

                case 6:
                System.out.println("삽입할 위치 입력(예)2 30): ");
                index = scan.nextInt();
                int insertData = scan.nextInt();
                for(int i=count; i>index; i--){
                    array[i] = array[i-1];
                }
                array[index] = insertData;
                count++;
                break; 

                case 0:
                scan.close();
                System.out.println("프로그램 종료");
                System.exit(0);
            }
        }
    }
}
