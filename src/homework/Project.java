package homework;
// Domain) 음악

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.PartialResultException;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

import ch05.sec05.EqualsExample;

// 사업 개요) 음악의 정보를 저장, 관리하고 기준에 따라 정렬 가능한 프로그램을 작성한다.

// 요구 사항 파악)
// 1: (I)nsert : Title, artist name, length, view count, Index(primary key)(기록 순서)를 기록한다. (add, insert) =insert 먼저 하고 append
// 2: (U)pdate  : 저장된 정보를 수정할 수 있어야 한다.
// 3: (R)ead : 저장된 정보는 Read할 수 있어야 한다. 이 때, 정렬해서 불러올 수도 있어야 한다. Read option에 sort가 있다.
// 4: (S)ort : 정렬한다. 기준을 먼저 입력 받고(view count, Index) 오름차순/ 내림차순(U/D)을 입력받는다.
// 5: (D)elete: 노래를 삭제한다.
// 6: (A)bout: artist name을 인수로 받아서 최대 조회수, 최저 조회수, 조회수 평균

public class Project {
    static final int MAX = 100;
    static String[] title = new String[MAX];
    static String[] artistName = new String[MAX];
    static int[] length = new int[MAX];
    static int[] viewCount = new int[MAX];
    static int[] idx = new int[MAX];

    static int count = 0;

    static Scanner scan = new Scanner(System.in);


    //노래 데이터 입력하기. 이미 등록된 노래 제목이 있다면 같은 노래고 취급하고 등록할 수 없음.
    private static void insertMusicData(){
        System.out.print("곡 제목: ");
        String stitle = scan.nextLine();
        int cnt = 0;
        for(int i=0; i<count; i++){
            if(stitle.equals(title[i])){
                System.out.println("이미 등록된 노래가 있습니다.");
                break;
            }else{
                cnt++;
            }
        }
        if(cnt != 0 || count == 0){
            title[count] = stitle;
            System.out.print("아티스트명: ");
            artistName[count] = scan.nextLine();
            System.out.print("곡 길이: ");
            length[count] = scan.nextInt();
            System.out.print("조회수: ");
            viewCount[count] = scan.nextInt();
            idx[count] = count;
            count++;
        }
    }

    //노래 수정 코드. 노래 제목을 통해 접근하고, 일치하는 노래 제목이 없다고 수정 불가.
    private static void updateMusicData(){
        System.out.println("수정이 필요한 노래 제목을 입력하세요.");
        String stitle = scan.nextLine();
        int index = -1;
        for(int i=0; i<count; i++){
            if(stitle.equals(title[i])){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("입력하신 노래 정보가 존재하지 않습니다.");
        }else{
            System.out.print("곡 제목: ");
            title[index] = scan.nextLine();
            System.out.print("아티스트명: ");
            artistName[index] = scan.nextLine();
            System.out.print("곡 길이: ");
            length[index] = scan.nextInt();
            System.out.print("조회수: ");
            viewCount[index] = scan.nextInt();
        }
    }

    //노래 데이터 출력
    private static void readMusicData(){
        System.out.println("==============================노래 정보==============================");
        for(int i=0; i<count; i++){
            System.out.println("곡 제목: " + title[i] + " 아티스트명: " + artistName[i] + " 곡 길이: " + length[i] + " 조회수: " + viewCount[i] + "순서: " + idx[i]);
        }
        System.out.println("==============================노래 정보==============================");
    }
    
    //노래 제목을 통한 노래 삭제. 일치하는 제목이 없다면 삭제 불가.
    private static void deleteMusicDate(){
        System.out.print("삭제하고 싶은 노래 제목을 입력하세요");
        String stitle = scan.nextLine();
        int index = -1;
        for(int i=0; i<count; i++){
            if(stitle.equals(title[i])){
                index = i;
            }
        }
        if(index != -1){
            for(int i=index; i<count-1; i++){
                title[i] = title[i+1];
                artistName[i] = artistName[i+1];
                length[i] = length[i+1];
                viewCount[i] = viewCount[i+1];
                count--;
            }
        }
        else{System.out.println("삭제할 노래가 존재하지 않습니다.");}
    }

    //입력된 아티스트의 곡 수, 뷰, 평균 뷰를 출력해준다.
    private static void averageMusicData(){
        System.out.print("아티스트를 입력해주세요");
        String artist = scan.nextLine();
        int index = -1;
        int vSum = 0;
        int cnt = 0;
        for(int i=0; i<count; i++){
            if(artist.equals(artistName[i])){
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int i=0; i<count; i++){
                if(artist.equals(artistName[i])){
                    cnt++;
                    vSum += viewCount[i];
                }
            }
        }else{
            System.out.println(artist + "는 존재하지 않습니다.");
        }
        double avg = (double)vSum / cnt;
        System.out.println("===================" + artist + "님====================");
        System.out.println("등록된 곡 수: " + cnt + "곡");
        System.out.println("총 뷰: " + vSum + "view");
        System.out.println("곡 당 평균 뷰: " + avg + "view");
    }   
    //조회수 순서소 버블정렬 실행
    private static void sort(){
        for(int k=0; k<count-1; k++){
            for(int i=0; i<count-1; i++){
                if(viewCount[i] < viewCount[i+1]){
                    swap(i);
                }
            }
                    
        }
        System.out.println("조회수를 기준으로 정렬 완료했습니다.");
    }

    private static void swap(int i){
        String temp = title[i];
        title[i] = title[i+1];
        title[i+1] = temp;
        temp = artistName[i];
        artistName[i] = artistName[i+1];
        artistName[i+1] = temp;
        int intTemp = length[i];
        length[i] = length[i+1];
        length[i+1] = intTemp;
        intTemp = viewCount[i];
        viewCount[i] = viewCount[i+1];
        viewCount[i+1] = intTemp;
    }
    
    public static void main(String[] args) {
        while(true){
            System.out.println("\n\n\n");
            System.out.println("Here is Melon administrator page");
            System.out.println("메뉴를 입력하세요.");
            System.out.println("(I)nsert, (U)pdate, (R)ead, (S)ort, (D)elete, (A)bout, (Q)uit");
            System.out.print("메뉴 입력: ");

            System.out.println("count: " + count);
            String select = scan.next();
            select = select.toLowerCase(); //소문자 변환
            scan.nextLine();
            
            switch(select.charAt(0)){
                case 'i':
                if(count > MAX){
                    System.out.println("멜론이 가득 찼습니다. 비우고 입력해주세요.");
                }else{
                    insertMusicData();
                }
                break;
                case 'u':
                updateMusicData();
                break;
                case 'r':
                if(count == 0){
                    System.out.println("데이터가 존재하지 않습니다.");
                }
                else{
                    readMusicData();
                }
                break;
                case 's':
                sort();
                break;
                case 'd':
                deleteMusicDate();
                break;
                case 'a':
                averageMusicData();
                break;
                case 'q':
                scan.close();
                System.exit(0);
                default:
                System.out.println("입력값이 틀렸습니다.");
            }

        }
    }
}
