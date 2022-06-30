import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(calculate(arr[1], arr[0]));
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int calculate(int c, int r) {
        if (dp[c][r] != 0) {
            return dp[c][r];
        }

        if (c == r || r == 0) {
            return dp[c][r] = 1;
        }

        return dp[c][r] = calculate(c - 1, r - 1) + calculate(c - 1, r);
    }
}