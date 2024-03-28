import java.util.Scanner;

public class Main {

    public static int N, M;
    public static int arr[];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        dfs(1, 0);

    }

    public static void dfs(int s, int depth) {

        if (depth == M){
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = s; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}