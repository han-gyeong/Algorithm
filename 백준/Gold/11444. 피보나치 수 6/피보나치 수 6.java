import java.util.Scanner;

public class Main {
    private static final int DIVISION = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        if (n != 0) {
            long[][] first = new long[][] {{1,1}, {1,0}};
            long[][] answer = solution(first, n);
            System.out.println(answer[0][1]);
        } else {
            System.out.println(0);
        }
    }

    private static long[][] solution(long[][] arr, long m) {
        if (m == 1) {
            return arr;
        }

        long[][] half = solution(arr, m/2);
        long[][] answer = matrixMulti(half, half);
        if (m % 2 == 1) {
            answer = matrixMulti(answer, arr);
        }

        return answer;
    }

    private static long[][] matrixMulti(long[][] first, long[][] second) {
        long[][] result = new long[first.length][second[0].length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second[0].length; j++) {
                for (int k = 0; k < second.length; k++) {
                    result[i][j] += (first[i][k] * second[k][j]) % DIVISION;
                }
                result[i][j] %= DIVISION;
            }
        }

        return result;
    }
}