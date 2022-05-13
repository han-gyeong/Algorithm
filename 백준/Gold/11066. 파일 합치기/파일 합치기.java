import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (--n >= 0) {
            int m = Integer.parseInt(br.readLine());
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[][] dp = new int[m][m];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], 0);
            }

            for (int i = 1; i < m; i++) {
                for (int j = i-1; j >= 0; j--) {
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < i - j; k++) {
                        min = Math.min(min, dp[j][j + k] + dp[j + k + 1][i]);
                    }

                    dp[j][i] = min + sumRange(array, j, i);
                }
            }

            System.out.println(dp[0][m - 1]);
        }
    }

    public static int sumRange(int[] arr, int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += arr[i];
        }

        return sum;
    }
}