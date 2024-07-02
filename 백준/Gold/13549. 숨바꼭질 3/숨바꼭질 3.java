
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int[] visit = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }

        });

        pq.offer(new int[]{s, 0});
        visit[s] = 1;

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();

            if (arr[0] == e) {
                System.out.println(arr[1]);
                break;
            } else {
                int loc = arr[0];
                int time = arr[1];
                visit[loc] = 1;

                if (loc+1 <= 100000 && visit[loc+1] == 0) {
                    pq.offer(new int[]{loc+1, time+1});
                }
                if (loc-1 >= 0 && visit[loc-1] == 0) {
                    pq.offer(new int[]{loc-1, time+1});
                }
                if (loc*2 <= 100000 && visit[loc*2] == 0) {
                    pq.offer(new int[]{loc*2, time});
                }
            }
        }
    }
}
