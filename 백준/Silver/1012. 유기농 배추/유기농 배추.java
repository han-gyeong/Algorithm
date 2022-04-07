import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{-1, 0, 0, 1}; // 왼쪽, 아래, 위, 오른쪽

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 갯수
        StringTokenizer st;

        while (--t >= 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken()); // 가로 길이
            int n = Integer.parseInt(st.nextToken()); // 세로 길이
            int k = Integer.parseInt(st.nextToken());

            // 배추 담을 배열, 체크 배열
            int[][] cabbage = new int[n][m];
            int[][] ch = new int[n][m];

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]); // 가로
                int y = Integer.parseInt(input[1]); // 세로
                cabbage[y][x] = 1;
            }

            int group = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cabbage[i][j] == 1 && ch[i][j] == 0) {
                        group++;
                        ch[i][j] = 1;
                        DFS(i, j, cabbage, ch);
                    }
                }
            }
            System.out.println(group);
        }
    }

    private static void DFS(int x, int y, int[][] cabbage, int[][] check) {
        for (int i = 0; i < dx.length; i++) {
            int desX = x + dx[i];
            int desY = y + dy[i];
            if (desX >= 0 && desX < cabbage.length && desY >= 0 && desY < cabbage[0].length && cabbage[desX][desY] == 1 && check[desX][desY] == 0) {
                check[desX][desY] = 1;
                DFS(desX, desY, cabbage, check);
            }
        }
    }
}