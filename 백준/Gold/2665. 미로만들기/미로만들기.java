
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int map[][];
    static int dis[][];
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[] dx = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dis = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dis[N-1][N-1]);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        dis[0][0] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (nx < N && ny < N && nx >= 0 && ny >= 0) {
                    if (dis[nx][ny] > dis[now.x][now.y]) {
                        if (map[nx][ny] == 1) {
                            dis[nx][ny] = dis[now.x][now.y];
                        } else {
                            dis[nx][ny] = dis[now.x][now.y] + 1;
                        }
                        q.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
