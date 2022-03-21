import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[][] arr;
    static int[] answer;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][];
        answer = new int[3];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        recursive(0, 0, n);

        sb.append(answer[0]).append('\n');
        sb.append(answer[1]).append('\n');
        sb.append(answer[2]);

        System.out.println(sb);
    }

    public static void recursive(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            answer[arr[x][y] + 1]++;
        } else {
            for (int i = x; i < x + size; i += size / 3) {
                for (int j = y; j < y + size; j += size / 3) {
                    recursive(i, j, size / 3);
                }
            }
        }
    }

    public static boolean isSameColor(int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}