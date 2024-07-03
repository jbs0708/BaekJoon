
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static String[][] arr;
    static int ans = 0;
    static int[] yi = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    static int[] xi = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visit;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        M = Integer.parseInt(temp[0]);
        N = Integer.parseInt(temp[1]);
        arr = new String[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            arr[i] = br.readLine().split(" ");
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j].equals("1")) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(ans);

        br.close();

    }

    public static void dfs(int a, int b) {
        q.offer(new int[]{a,b});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            arr[y][x] = "0";

            for (int i = 0; i < 8; i++) {
                if (y+yi[i] >= 0 && y+yi[i] < M && x+xi[i] >= 0 && x+xi[i] < N) {
                    if (arr[y+yi[i]][x+xi[i]].equals("1") && !visit[y+yi[i]][x+xi[i]]) {
                        visit[y+yi[i]][x+xi[i]] = true;
                        q.offer(new int[]{y+yi[i],x+xi[i]});
                    }
                }
            }
        }
    }
}
