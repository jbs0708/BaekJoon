import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int T = 1; T <= 10; T++) {
            int[][] arr = new int[100][100];
            int rowSum[] = new int[100];
            int colSum[] = new int[100];
            int t = Integer.parseInt(sc.nextLine());
            int arrMax = Integer.MIN_VALUE;
            int diaMax = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            int diagonal1 = 0;  // 대각선1
            int diagonal2 = 0;  // 대각선2

            for (int i = 0; i < 100; i++) {
                int rowTemp = 0;
                StringTokenizer st = new StringTokenizer(sc.nextLine()," ");
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    colSum[j] += arr[i][j];
                    rowTemp += arr[i][j];
                    if (i == j) {
                        diagonal1 += arr[i][j];
                    }
                    if ((i+j) == 99) {
                        diagonal2 += arr[i][j];
                    }
                }
                rowSum[i] = rowTemp;
            }
            Arrays.sort(colSum);  // 오름차순 정리
            Arrays.sort(rowSum);  // 오름차순 정리

            arrMax = Math.max(rowSum[99],colSum[99]);  // 행,열 최댓값 비교
            diaMax = Math.max(diagonal1,diagonal2);    // 대각선 두개 최댓값 비교
            max = Math.max(diaMax,arrMax);             // 최종 최댓값 비교

            System.out.printf("#%d %d\n",t,max);
        }
    }
}