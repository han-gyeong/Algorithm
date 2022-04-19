import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int INF = 100_000_001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];

        // 배열 값 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = INF;
            }
        }

        // 값 채우기
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[from][to] = Math.min(arr[from][to], cost);
        }

        for (int i = 1; i <= n; i++) { // 가운데
            for (int j = 1; j <= n; j++) { // 시작
                for (int k = 1; k <= n; k++) { // 끝
                    if (arr[j][i] == INF || arr[i][k] == INF) {
                        continue;
                    }

                    if (arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(arr[i][j] == INF ? 0 : arr[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}