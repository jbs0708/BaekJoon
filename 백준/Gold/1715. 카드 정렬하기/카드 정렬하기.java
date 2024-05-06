import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long ans = 0;

        PriorityQueue<Long> pq =new PriorityQueue<Long>();

        for (int i = 0; i < N; i++) {
            pq.add(sc.nextLong());
        }

        while (pq.size() > 1) {
            long l1 = pq.poll();
            long l2 = pq.poll();

            ans += l1 + l2;
            pq.add(l1 + l2);
        }

        System.out.println(ans);
    }
}