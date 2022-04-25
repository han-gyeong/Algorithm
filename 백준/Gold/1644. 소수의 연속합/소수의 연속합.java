import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

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

    // N 이하의 소수들을 반환해주는 함수
    public static int[] getPrimeNumbersBeforeN(int n) {
        // -1 -> 소수가 아님, 0은 아직 안간 곳, 1은 소수
        int[] arr = new int[n+1];
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