import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = solution(n, k, arr);
        System.out.println(answer);
    }

    public static int solution(int n, int k, int[] arr) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;
        for (int i = k; i < n; i++) {
            sum = (sum + arr[i]) - arr[i-k];

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}