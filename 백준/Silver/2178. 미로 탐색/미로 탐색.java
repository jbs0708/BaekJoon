import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int map[][];
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs();
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs() {
        int x[] = {0,0,-1,1};
        int y[] = {-1,1,0,0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.offer(0);
        qy.offer(0);
        visit[0][0] = true;
        int x1 = 0;
        int y1 = 0;

        while (!qx.isEmpty() && !qy.isEmpty()) {
            x1 = qx.poll();
            y1 = qy.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = x1 + x[i];
                int y2 = y1 + y[i];

                if (x2 >= 0 && x2 < N && y2 >= 0 && y2 < M) {
                    if (map[x2][y2] == 1 && !visit[x2][y2]) {
                        qx.offer(x2);
                        qy.offer(y2);
                        map[x2][y2] = map[x1][y1] + 1;
                        visit[x2][y2] = true;
                    }
                }
            }
        }
    }
}