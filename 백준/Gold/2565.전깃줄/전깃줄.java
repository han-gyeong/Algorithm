import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[501];
        dp = new int[501];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            arr[from] = to;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && arr[j] != 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(n - answer);
    }
}