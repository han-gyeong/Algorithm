import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long m = scan.nextLong();
        int[][] first = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                first[i][j] = (scan.nextInt() % 1000);
            }
        }

        int[][] solution = solution(first, m);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                sb.append(solution[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static int[][] solution(int[][] arr, long m) {
        if (m == 1) {
            return arr;
        }

        int[][] tmp = solution(arr, m / 2);
        int[][] answer = calculate(tmp, tmp);

        if (m % 2 == 1) {
            return calculate(answer, arr);
        }
        return answer;
    }

    static int[][] calculate(int[][] arr, int[][] arr2) {
        int[][] result = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    result[i][j] += (arr[i][k] * arr2[k][j]) % 1000;
                }
                result[i][j] %= 1000;
            }
        }

        return result;
    }
}