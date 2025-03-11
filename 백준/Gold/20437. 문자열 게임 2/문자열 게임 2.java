import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());
            LinkedList<Integer>[] alphabet = new LinkedList[26];
            int max = 0;
            int min = 10000;
            boolean found = false;

            for (int i = 0; i < 26; i++) {
                alphabet[i] = new LinkedList<>();
            }

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                alphabet[c-'a'].add(i);
            }

            for (int i = 0; i < 26; i++) {
                if (alphabet[i].size() >= k) {
                    found = true;
                    for (int j = 0; j <= alphabet[i].size() - k; j++) {
                        if (alphabet[i].get(j+k-1)-alphabet[i].get(j) < min) {
                            min = alphabet[i].get(j+k-1)-alphabet[i].get(j);
                        }
                        if (alphabet[i].get(j+k-1)-alphabet[i].get(j) > max) {
                            max = alphabet[i].get(j+k-1)-alphabet[i].get(j);
                        }
                    }
                }
            }

            if (!found) {
                System.out.println(-1);
            } else {
                System.out.println((min+1) + " " + (max+1));
            }
        }
    }
}
