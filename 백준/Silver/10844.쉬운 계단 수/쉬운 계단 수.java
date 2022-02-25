import java.util.Scanner;

public class Main {
    static Long[][] dp;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new Long[n + 1][10];

        dp[1][0] = 0L;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += find(n, i);
        }

        System.out.println(sum % 1_000_000_000L);
    }

    public static long find(int N, int num) {
        if (num >= 10 || num < 0) {
            return 0;
        }

        if (dp[N][num] == null) {
            dp[N][num] = (find(N-1, num + 1) + find(N-1, num - 1));
        }

        return dp[N][num] % 1_000_000_000L;
    }
}