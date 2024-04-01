import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int[] visited = new int[N];

        ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 500, visited);
        System.out.println(ans);

    }

    public static void dfs(int idx, int depth, int temp, int[] visited) {

        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                temp -= M;
                temp += arr[i];
                if (temp >= 500) {
                    dfs(i, depth+1, temp, visited);
                }
                temp += M;
                temp -= arr[i];
                visited[i] = 0;
            }
        }

    }
}