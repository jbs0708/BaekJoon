
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> graph = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[] {e, d});
            graph.get(e).add(new int[] {s, d});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        if (E == 0) {
            System.out.println(-1);
        } else if (N == E) {
            System.out.println(0);
        } else {
            int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
            int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

            int ans = Math.min(path1, path2);
            if (ans < 0) {
                ans = -1;
            }

            System.out.println(ans);
        }
    }


    public static int dijkstra(int start, int end) {
        if (start == end) {
            return 0;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        pq.add(new int[] {start, 0});
        dis[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curWeight = cur[1];

            if (dis[curNode] < curWeight) {
                continue;
            }

            for (int[] neighbor : graph.get(curNode)) {
                int nextNode = neighbor[0];
                int weight = dis[curNode] + neighbor[1];

                if (weight < dis[nextNode]) {
                    dis[nextNode] = weight;
                    pq.add(new int[] {nextNode, weight});
                }
            }
        }

        return dis[end];
    }
}
