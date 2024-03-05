import java.util.Scanner;

public class Main {

    static int N;
    static int ans = 0;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new int[N];

        dfs(0);

        System.out.println(ans);
    }

    // 해당 행(depth)에 대해 탐색
    public static void dfs(int depth) {
        // 깊이가 배열의 사이즈를 초과했다면 카운트 하나 쌓고 종료
        if (depth == N) {
            ans++;
            return;
        }

        // 각 열에 대해서
        for (int i = 0; i < N; i++) {
            // (depth 행, i 열)에 배치했을 때,
            visited[depth] = i;
            
            // 배치가 가능한지 체크
            if (check(depth)) {
                // 가능하다면 다음 행으로 진입
                dfs(depth+1);
            }

        }
    }

    // 배치가 가능한지 체크
    public static boolean check(int idx) {

        // 0행에서부터 깊이(idx)까지 탐색
        for (int i = 0; i < idx; i++) {

            // 상위 행들 중에 같은 열에 이미 퀸이 존재한다면 false 리턴
            if (visited[i] == visited[idx]) {
                return false;
                
            // 대각선 위치에 존재하는지 여부를 확인하기 위해,
            // 열끼리의 차와 행끼리의 차가 같은지 확인.
            // (각 행,열의 인덱스 차이값이 같다면 대각선 위치이다)    
            } else if (Math.abs(idx - i) == Math.abs(visited[idx] - visited[i])) {
                return false;
            }
        }

        return true;
    }
}