package ch05.sec07;

public class MultidimensionalArrayByValueListExample {
    public static void main(String[] args) {
        int[][] scores = {
            {80,90,96},
            {76,88}
        };

        //배열의 길이
        System.out.println("1차원 배열 길의(반의 수): " + scores.length);
        System.out.println("2차원 배열 길이(첫번 째 반의 학생 수)): " + scores[0].length);
        System.out.println("2차원 배열 길이(두번 째 반의 학생 수)): " + scores[1].length);

        //첫 번째 반의 세 번째 학생의 점수 읽기
        System.out.println("scores[0][2] : " + scores[0][2]);

        //두 번째 반의 두 번째 학생의 점수 읽기
        System.out.println("scores[1][1] : " + scores[1][1]);

        //첫 번째 반의 평균 점수 구하기
        int class1Sum = 0;
        for(int i=0; i<scores[0].length; i++){
            class1Sum += scores[0][i];
        }
        System.out.println("첫 번째 반의 평균 점수 : " + (double)class1Sum / scores[0].length);

        //두 번째 반의 평균 점수 구하기
        int class2Sum = 0;
        for(int i=0; i<scores[1].length; i++){
            class2Sum += scores[1][i];
        }
        System.out.println("두 번째 반의 평균 점수 : " + (double)class2Sum / scores[1].length);

        //전체 학생의 평균 점수
        int sum = 0;
        int num = 0;
        for(int i=0; i<scores.length; i++){
            num += scores[i].length;
            for(int j=0; j<scores[i].length; j++){
                sum += scores[i][j];
            }
        }
        double totalAvg = (double) sum  / num;
        System.out.println("전체 학생 평균 점수는 : " + totalAvg);

    }
}
