import java.util.Scanner;


public class Main {

    static int cnt;
    static int M, N;
    static int num;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T--> 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            num = sc.nextInt();

            boolean visit[][] = new boolean[M][N];
            int arr[][] = new int[M][N];
            int ans = 0;

            for (int i = 0; i < num; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1 && !visit[i][j]) {
                        dfs(i,j,visit,arr);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void dfs(int x, int y, boolean visit[][], int arr[][]) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xt = x + dx[i];
            int yt = y + dy[i];
            //  범위 체크             범위 체크              벌레가 있는지 확인
            if (xt >= 0 && xt < M && yt >= 0 && yt < N && !visit[xt][yt] && arr[xt][yt] == 1) {
            //             범위 체크              범위 체크                     배추가 있는지 확인
                dfs(xt,yt,visit,arr);
            }
        }
    }
}