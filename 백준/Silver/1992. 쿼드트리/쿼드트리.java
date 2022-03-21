import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] arr;
    static int[] answer;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        answer = new int[2];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        recursive(0, 0, n);

        System.out.println(sb);
    }

    public static void recursive(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            sb.append(arr[x][y]);
        } else {
            sb.append('(');
            for (int i = x; i < x + size; i += size / 2) {
                for (int j = y; j < y + size; j += size / 2) {
                    recursive(i, j, size / 2);
                }
            }
            sb.append(')');
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