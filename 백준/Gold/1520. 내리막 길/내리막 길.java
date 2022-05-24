import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] toX = {-1, 0, 0, 1};
    public static int[] toY = {0, -1, 1, 0};
    public static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        DFS(0, 0, arr, dp);

        System.out.println(dp[0][0]);
    }

    public static int DFS(int x, int y, int[][] arr, int[][] dp) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }

        if (dp[x][y] >= 0) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < toX.length; i++) {
            int dx = x + toX[i];
            int dy = y + toY[i];

            if (dx >= 0 && dx < m && dy >= 0 && dy < n && arr[dx][dy] < arr[x][y]) {
                dp[x][y] += DFS(dx, dy, arr, dp);
            }
        }

        return dp[x][y];
    }
}