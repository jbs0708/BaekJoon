import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int arr[];
    static int variety[] = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0, 0, 0, 0, 0));

    }

    public static int dfs(int rp, int lp, int cnt, int kind, int max) {
        if (rp == N) {
            return max;
        }

        if (variety[arr[rp]] == 0) {
            kind++;
        }
        variety[arr[rp]]++;
        cnt++;

        if (kind > 2) {
            variety[arr[lp]]--;
            cnt--;
            if (variety[arr[lp]] == 0) {
                kind--;
            }
            lp++;
        }

        max = Math.max(max, cnt);

        return dfs(rp+1, lp, cnt, kind, max);
    }

}
