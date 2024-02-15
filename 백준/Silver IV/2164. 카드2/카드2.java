import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n*2];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int first = 1;
        int last = n;
        
        while (n-- > 1) {
            first++;
            arr[last + 1] = arr[first];
            last++;
            first++;
        }

        System.out.println(arr[first]);
    }
}