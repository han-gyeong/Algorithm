import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int lt = 0;
        int sum = 0;
        int answer = 0;

        int[] primeNumbers = getPrimeNumbersBeforeN(n);
        for (int rt = 0; rt < primeNumbers.length; rt++) {
            sum += primeNumbers[rt];

            while (sum >= n && lt <= rt) {
                if (sum == n) {
                    answer++;
                }

                if (sum >= n) {
                    sum -= primeNumbers[lt];
                    lt++;
                }
            }
        }

        System.out.println(answer);
    }

    public static int[] getPrimeNumbersBeforeN(int n) {
        int[] arr = new int[n+1];
        // -1 -> 소수가 아님, 0은 아직 안간 곳, 1은 소수
        arr[0] = -1;
        arr[1] = -1;

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                continue;
            }

            arr[i] = 1;
            for (int j = i * 2; j <= n; j += i) {
                arr[j] = -1;
            }
        }

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers.stream().mapToInt(i -> i).toArray();
    }
}