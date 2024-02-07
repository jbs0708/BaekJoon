
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();


            if (str.equals("push")) {
                push(Integer.parseInt(st.nextToken()));
            } else if (str.equals("pop")) {
                sb.append(pop() + " ");
            } else if (str.equals("size")) {
                sb.append(size() + " ");
            } else if (str.equals("empty")) {
                sb.append(empty() + " ");
            } else if (str.equals("top")) {
                sb.append(top() + " ");
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static void push(int num) {
        stack[size] = num;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int temp = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return temp;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size - 1];
        }
    }
}
