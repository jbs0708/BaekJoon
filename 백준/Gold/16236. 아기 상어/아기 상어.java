import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        matrix = new int[N][N];
        int[] cur = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == 9) {
                    cur = new int[]{i, j};
                    matrix[i][j] = 0;
                }
            }
        }

        int shark = 2;
        int ateFish = 0;
        int cnt = 0;


        while (true) {
            // 1차: 물고기 사이즈 별로 정렬
            // 2차: 물고기 y축 비교 (위에서부터)
            // 3차: 물고기 x축 비교 (왼쪽에서부터)
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->
                o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[N][N];
            visit[cur[0]][cur[1]] = true;
            
            // 좌표 + 이동거리
            q.add(new int[]{cur[0], cur[1], 0});

            // 물고기를 먹었는지 여부 확인
            boolean found = false;

            // bfs
            while (!q.isEmpty()) {
                cur = q.poll();

                if (matrix[cur[0]][cur[1]] != 0 && matrix[cur[0]][cur[1]] < shark) {
                    matrix[cur[0]][cur[1]] = 0;
                    ateFish++;
                    cnt += cur[2];
                    found = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[ny][nx] || matrix[ny][nx] > shark) {
                        continue;
                    }

                    q.add(new int[]{ny, nx, cur[2]+1});
                    visit[ny][nx] = true;
                }

            }

            if (!found) {
                break;
            }

            if (shark == ateFish) {
                ateFish = 0;
                shark++;
            }
        }
        System.out.println(cnt);
    }
}
