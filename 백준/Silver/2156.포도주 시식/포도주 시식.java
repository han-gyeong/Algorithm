import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }

        dp[0] = arr[0] = 0;
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], Math.max(dp[i-2] + arr[i], dp[i-1]));
        }

        System.out.println(dp[n]);
    }
}