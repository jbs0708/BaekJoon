
import java.util.Scanner;

public class Main {

    static int size;
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            size = sc.nextInt();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            int goal = sc.nextInt();
            dp = new int[goal+1];
            dp[0] = 1;

            for (int i = 0; i < size; i++) {
                for (int j = arr[i]; j <= goal; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }

            System.out.println(dp[goal]);

        }
    }
}
