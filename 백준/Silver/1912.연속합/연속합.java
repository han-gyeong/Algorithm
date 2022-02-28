import java.util.Scanner;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}