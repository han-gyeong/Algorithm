import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int maxWeight = scan.nextInt();
        int[] dp = new int[maxWeight+1];
        Arrays.fill(dp, 0);

        for (int i = 0; i < n; i++) {
            int weight = scan.nextInt();
            int value = scan.nextInt();

            for (int j = maxWeight; j >= weight; j--) {
                dp[j] = Math.max(dp[j - weight] + value, dp[j]);
            }
        }

        System.out.println(dp[maxWeight]);
    }
}