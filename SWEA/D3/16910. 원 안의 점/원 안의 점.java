import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int r = sc.nextInt();
            int cnt = 0;
            for (int i = 0; i <= r; i++) {
                for (int j = 1; j <= r; j++) {
                    if ((i*i) + (j*j) <= (r*r)) {
                        cnt++;
                    }
                }
            }
            cnt = cnt * 4;
            cnt++;
            System.out.printf("#%d %d\n", t, cnt);
        }
    }
}
