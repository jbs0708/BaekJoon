import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;
    static int[] visit;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][2];
        visit = new int[N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        dfs(0, visit, 0);
        System.out.println(ans);


    }

    public static void dfs(int idx, int[] v, int temp) {

        if (idx >= N) {
            ans = Math.max(ans, temp);
            return;
        } else {

            for (int i = idx; i < N; i++) {
                if (v[i] == 0 && arr[i][0] + i <= N) {
                    v[i] = 1;
                    dfs(i+arr[i][0], v, temp+arr[i][1]);
                    v[i] = 0;
                }
            }
        }
        ans = Math.max(ans, temp);
        return;
    }
}
