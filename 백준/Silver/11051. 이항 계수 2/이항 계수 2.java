import java.util.Scanner;

public class Main {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        dp = new long[a + 1][b + 1];

        System.out.println(recursive(a, b));
    }

    public static long recursive(int a, int b) {
        if (dp[a][b] == 0) {
            if (b == 1) {
                dp[a][b] = a;
            } else if (a == b || b == 0) {
                dp[a][b] = 1;
            } else {
                dp[a][b] = (recursive(a - 1, b - 1) % 10007 + recursive(a - 1, b) % 10007);
            }
        }

        return dp[a][b] % 10007;
    }
}