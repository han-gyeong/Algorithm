import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n][];
        dp = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            dp[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                dp[i + 1][j] = Math.max(dp[i+1][j], dp[i][j] + arr[i+1][j]);
                dp[i + 1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + arr[i+1][j+1]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        System.out.println(answer);
    }
}