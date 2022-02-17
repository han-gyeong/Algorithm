import java.util.Scanner;

public class Main {
    static char[][] stars;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void fill(int x, int y, int size, boolean isBlank) {

        if (isBlank) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        if (size == 1) {
            stars[x][y] = '*';
            return;
        }

        int count = 0;
        int tmp = size / 3;
        for (int i = x; i < x + size; i += tmp) {
            for (int j = y; j < y + size; j += tmp) {
                count++;
                if (count == 5) {
                    fill(i, j, tmp, true);
                } else {
                    fill(i, j, tmp, false);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        stars = new char[n][n];

        fill(0, 0, n, false);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}