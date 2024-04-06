import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int max_v, min_v, N;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        int[] op = new int[4];
        max_v = -1000000000;
        min_v = 1000000000;


        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(op, arr[0], 0);
        System.out.println(max_v);
        System.out.println(min_v);

    }

    public static void dfs(int[] op, int temp, int idx) {

        if (Arrays.stream(op).sum() == 0) {
            max_v = Math.max(max_v, temp);
            min_v = Math.min(min_v, temp);
            return;
        } else if (idx == N-1) {
            return;
        }

        if (op[0] > 0) {
            op[0]--;
            dfs(op, temp + arr[idx+1], idx+1);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            dfs(op, temp - arr[idx+1], idx+1);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            dfs(op, temp * arr[idx+1], idx+1);
            op[2]++;
        }

        if (op[3] > 0) {
            op[3]--;
            dfs(op, temp / arr[idx+1], idx+1);
            op[3]++;
        }
    }
}