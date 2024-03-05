import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        int[] visited = new int[N];
        int[] ans = new int[M];

        dfs(visited, ans, 0);


    }

    public static void dfs(int[] visited, int[] ans, int idx) {
        int sum = Arrays.stream(visited).sum();
        if (sum == M) {
            for (int i = 0; i < M; i++) {
                System.out.printf("%d ",ans[i]);
            }
            System.out.println();
        } else {
            for (int i = idx; i < N; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    ans[sum] = arr[i];
                    dfs(visited, ans, i);
                    ans[sum] = 0;
                    visited[i] = 0;
                }
            }
        }
    }
}