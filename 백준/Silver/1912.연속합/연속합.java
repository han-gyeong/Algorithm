import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[n];

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