import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n][n];
        answer = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        recursive(0, 0, n);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void recursive(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            answer[arr[x][y]]++;
        } else {
            for (int i = x; i < x + size; i += size / 2) {
                for (int j = y; j < y + size; j += size / 2) {
                    recursive(i, j, size / 2);
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