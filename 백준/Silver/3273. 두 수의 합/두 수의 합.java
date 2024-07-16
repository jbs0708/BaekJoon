import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int X = Integer.parseInt(br.readLine());
        int ans = 0;

        Arrays.sort(arr);
        int rp = N-1;
        int lp = 0;

        while (true) {
            if (rp == lp) break;

            int temp = arr[rp] + arr[lp];
            if (temp < X) {
                lp++;
            } else if (temp > X) {
                rp--;
            } else {
                ans++;
                lp++;
            }
        }

        System.out.println(ans);
    }
}
