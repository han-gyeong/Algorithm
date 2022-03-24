import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] first = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                first[i][j] = scan.nextInt();
            }
        }

        m = scan.nextInt();
        int k = scan.nextInt();
        int[][] second = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                second[i][j] = scan.nextInt();
            }
        }

        int[][] arr = calculate(first, second);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static int[][] calculate(int[][] first, int[][] second) {
        int[][] result = new int[first.length][second[0].length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[i][j] += first[i][k] * second[k][j];
                }
            }
        }

        return result;
    }
}