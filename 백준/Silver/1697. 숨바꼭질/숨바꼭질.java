import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int sec[] = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        sec[N] = 1;  // print 할 때 -1

        while (!q.isEmpty()) {
            int location = q.poll();

            if (location == K) {
                break;
            }

            if (location - 1 >= 0 && sec[location-1] == 0) {
                q.offer(location-1);
                sec[location-1] = sec[location] + 1;
            }

            if (location + 1 <= 100000 && sec[location+1] == 0) {
                q.offer(location+1);
                sec[location+1] = sec[location] + 1;
            }

            if (location * 2 <= 100000 && sec[location * 2] == 0) {
                q.offer(location * 2);
                sec[location * 2] = sec[location] + 1;
            }
        }

        System.out.println(sec[K] - 1);  // sec[N] = 1; 에서 뺌
    }
}