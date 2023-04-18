package testPage.codingTest;

import java.util.Scanner;
import java.io.FileInputStream;


class Sol {
	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
        String[] result = new String[T];
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            sc.nextLine();
            int h = -1;
            int w = -1;
            int H = 0;
            String[][] jangi = new String[N][N];
            for(int i=0; i<N; i++){
                jangi[i] = sc.nextLine().split(" ");
                for(int j=0; j<N; j++){
                    if(jangi[i][j].equals("X")){
                        h = i;
                        w = j;
                    }
                }
            }
            for(int i=w+1; i<N; i++){
                if(jangi[h][i].equals("L")) continue;
                if(jangi[h][i].equals("Y")) break;
                if(jangi[h][i].equals("H")){
                    H++;
                }
                if(H == 2){
                    AnswerN++;
                    H=0;
                    break;
                }
            }
            for(int i=w-1; i>=0; i--){
                if(jangi[h][i].equals("L")) continue;
                if(jangi[h][i].equals("Y")) break;
                if(jangi[h][i].equals("H")){
                    H++;
                }
                if(H == 2){
                    AnswerN++;
                    H=0;
                    break;
                }
            }
            for(int i=h-1; i>=0; i--){
                if(jangi[i][w].equals("L")) continue;
                if(jangi[i][w].equals("Y")) break;
                if(jangi[i][w].equals("H")){
                    H++;
                }
                if(H == 2){
                    AnswerN++;
                    H=0;
                    break;
                }
            }
            for(int i=h+1; i<N; i++){
                if(jangi[i][w].equals("L")) continue;
                if(jangi[i][w].equals("Y")) break;
                if(jangi[i][w].equals("H")){
                    H++;
                }
                if(H == 2){
                    AnswerN++;
                    H=0;
                    break;
                }
            }
            result[test_case - 1] = "#"+test_case+" "+AnswerN;
            AnswerN = 0;
		}
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
        sc.close();
	}
}
