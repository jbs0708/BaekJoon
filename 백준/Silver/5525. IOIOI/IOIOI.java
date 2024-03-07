import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int[] check = new int[S];
        int cnt = 0;

        for (int i = 1; i < S-1; i++) {
            if (arr[i] == 'O' && arr[i+1] == 'I') {
                check[i+1] = check[i-1] + 1;
                
                if (check[i+1] >= N && arr[i - (N*2) + 1] == 'I') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }
}