import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int cnt;
    static char arr[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            cnt = 0;

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                char c[] = str.toCharArray();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = c[j];
                }
            }

            // 길이가 1인 회문의 갯수는 판의 넓이와 같으므로 8*8 = 64 
            if (n == 1) {
                System.out.printf("#%d 64\n", t);
                continue;
            }

            // 각 위치에 대해서 가로세로 방향으로 탐색
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    // 행
                    row(i,j);
                    // 열
                    column(i,j);
                }
            }

            System.out.printf("#%d %d\n", t, cnt);

        }
    }

    // 세로방향
    public static void column(int x, int y) {
        int plus = y;
        int minus = y;
        // 회문 길이의 홀수짝수 판별 후, 짝수라면 비교할 위치에 +1
        if (n%2 == 0) plus++;

        // 회문 길이 측정
        int count = 0;
        
        // 판의 범위에서 벗어나지 않도록 설정
        while (plus < 8 && minus >= 0) {
            // 회문이 성립하지 않는다면 반복문 탈출
            if (arr[x][plus] != arr[x][minus]) break;

            // 회문 길이 카운트
            count++;
            // 비교위치 조정 
            plus++;
            minus--;

            // 주어진 길이만큼 회문이 성립하면 카운트 추가 후 반복문 탈출
            if (n%2 == 1 && count == (n/2) + 1) {
                cnt++;
                break;
            }
            if (n%2 == 0 && count == (n/2)) {
                cnt++;
                break;
            }
        }
    }

    // 가로방향
    public static void row(int x, int y) {
        int plus = x;
        int minus = x;
        if (n%2 == 0) plus++;

        // 회문 길이 측정
        int count = 0;

        // 판의 범위에서 벗어나지 않도록 설정
        while (plus < 8 && minus >= 0) {
            // 회문이 성립하지 않는다면 반복문 탈출
            if (arr[plus][y] != arr[minus][y]) break;
            
            // 회문 길이 카운트
            count++;
            // 비교위치 조정 
            plus++;
            minus--;
            
            // 주어진 길이만큼 회문이 성립하면 카운트 추가 후 반복문 탈출
            if (n%2 == 1 && count == (n/2) + 1) {
                cnt++;
                break;
            }
            if (n%2 == 0 && count == (n/2)) {
                cnt++;
                break;
            }
        }
    }
}
