import java.util.Scanner;

public class Main {
    static int[][] arr;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < arr[n-1].length; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        System.out.println(find(0, 0));
    }

    public static int find(int depth, int index) {
        if (depth == n-1) {
            return dp[n-1][index];
        }

        if (dp[depth][index] == null) {
            return dp[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + arr[depth][index];
        }

        return dp[depth][index];
    }
}