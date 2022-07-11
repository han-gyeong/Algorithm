import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n + 1; i++) {
            arr[i-1] = i;
        }

        int lt = 0;
        int rt = 0;
        int sum = arr[0];
        int answer = 0;

        while (lt <= rt) {
            if (sum < n) {
                sum += arr[++rt];
            } else {
                if (sum == n) {
                    answer++;
                }

                sum -= arr[lt++];
            }
        }

        System.out.println(answer);
    }
}
