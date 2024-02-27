import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        st = new StringTokenizer(str," ");

        int[] arr = new int[n];
        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        while (max > min) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < arr.length; i++) {
                
                if (arr[i] - mid > 0) {
                    sum += (arr[i] -mid);
                }
            }
            
            if (sum < m) {
                max = mid;
            } else {
                // (max > min)의 조건을 깨기 위해
                min = mid + 1;
            }

        }

        
        System.out.println(min - 1);
        br.close();
    }
}
