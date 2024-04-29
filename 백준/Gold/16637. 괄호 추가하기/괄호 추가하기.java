import java.util.Scanner;

public class Main{
    static int n, m;
    static int[] arr;
    static char[] str;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        String inpStr = sc.nextLine();

        m = n/2;
        arr = new int[m+1];
        str = new char[m];
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                arr[i/2] = Integer.parseInt(String.valueOf(inpStr.charAt(i)));
            } else {
                str[i/2] = inpStr.charAt(i);
            }
        }
        ans = Integer.MIN_VALUE;
        dfs(arr[0], 0);
        System.out.println(ans);


    }

    private static void dfs(int temp, int index) {
        if(index>=m){
            ans = Math.max(temp,ans);
            return;
        }

        int sum1 = cal(str[index], temp, arr[index+1]);
        dfs(sum1, index+1);

        if(index+1 <m){
            int sum2 = cal(str[index+1],arr[index+1],arr[index+2]);
            dfs(cal(str[index],temp,sum2),index+2);
        }
    }


    public static int cal(char op, int n1, int n2){
        if(op=='+'){
            return n1+n2;
        }
        else if(op=='-'){
            return n1-n2;
        }
        else{
            return n1*n2;
        }
    }
}
