import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] arr, dp;
    public static int N, M, ans;
    public static int[] dirs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        dirs = new int[]{-1, 0 , 1};
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(0, i, arr[0][i], -1);
        }

        System.out.println(ans);
    }

    public static void dfs(int row, int col, int temp, int dir) {
        if (row >= N-1) {
            ans = Math.min(ans, temp);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i == dir) {
                continue;
            }

            if (0 <= (col + dirs[i]) && (col + dirs[i]) < M) {
                dfs(row+1, col+ dirs[i], temp + arr[row+1][col+ dirs[i]], i);
                if (temp + arr[row+1][col+ dirs[i]] < dp[row+1][col+ dirs[i]]) {
                    dp[row+1][col+ dirs[i]] = temp + arr[row+1][col+ dirs[i]];
                }
            }
        }
    }
}
