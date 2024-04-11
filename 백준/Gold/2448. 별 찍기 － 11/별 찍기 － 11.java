import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public  static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        arr = new char[k][2*k-1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(arr[i], ' ');
        }

        tri(0, k-1, k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 2*k-1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void tri(int y, int x, int n) {
        if (n == 3) {
            arr[y][x] = '*';
            arr[y+1][x-1] = arr[y+1][x+1] = '*';
            arr[y + 2][x - 2] = arr[y + 2][x - 1] = arr[y + 2][x] = arr[y + 2][x + 1] = arr[y + 2][x + 2] = '*';
            return;
        }

        tri(y, x, n/2);
        tri(y + n/2, x - n/2, n/2);
        tri(y + n/2, x + n/2, n/2);

    }
}