import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        int lcsLength = LCS(a, b, dp);
        String lcs = findLCS(a, b, dp);

        System.out.println(lcsLength);
        System.out.println(lcs);
    }

    private static int LCS(String a, String b, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[a.length()][b.length()];
    }

    private static String findLCS(String a, String b, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        int x = a.length();
        int y = b.length();

        while (dp[x][y] != 0 && x != 0 && y != 0) {
            if (a.charAt(x - 1) == b.charAt(y - 1)) {
                sb.append(a.charAt(x - 1));
                x -= 1;
                y -= 1;
            } else {
                if (dp[x][y] == dp[x-1][y]) {
                    x = x-1;
                } else {
                    y = y-1;
                }
            }
        }

        return sb.reverse().toString();
    }
}