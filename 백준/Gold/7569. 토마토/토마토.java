import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PointXYZ {
    int x;
    int y;
    int z;
    public PointXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int M, N, H;
    static int[][][] arr;
    static int[][][] counter;
    static boolean[][][] visit;

    static Queue<PointXYZ> q = new LinkedList<PointXYZ>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H+1][N+1][M+1];
        counter = new int[H+1][N+1][M+1];
        visit = new boolean[H+1][N+1][M+1];



        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(temp.nextToken());
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        q.add(new PointXYZ(k,j,i));
                        counter[i][j][k] = 1;
                    } else if(arr[i][j][k] == -1) {
                        counter[i][j][k] = -1;
                    }
                }
            }
        }

        System.out.println(bfs());


    }

    public static int bfs() {
        int[] New_X = {-1,1,0,0,0,0};
        int[] New_Y = {0,0,-1,1,0,0};
        int[] New_Z = {0,0,0,0,-1,1};

        while (!q.isEmpty()) {
            PointXYZ temp = q.poll();

            for (int i = 0; i < 6; i++) {
                int new_x = temp.x + New_X[i];
                int new_y = temp.y + New_Y[i];
                int new_z = temp.z + New_Z[i];

                if (new_x >= 0 && new_y >= 0 && new_z >= 0 && new_x < M && new_y < N && new_z < H) {
                    if (arr[new_z][new_y][new_x] == 0 && !visit[new_z][new_y][new_x]) {
                        q.add(new PointXYZ(new_x, new_y, new_z));
                        visit[new_z][new_y][new_x] = true;
                        counter[new_z][new_y][new_x] = counter[temp.z][temp.y][temp.x] + 1;
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (counter[i][j][k] == 0) {
                        return -1;
                    }
                    max = Math.max(max, counter[i][j][k]);
                }
            }
        }
        
        return max - 1;
    }
}
