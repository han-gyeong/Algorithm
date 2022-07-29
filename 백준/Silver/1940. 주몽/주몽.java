import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;
        int answer = 0;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum > m) {
                rt--;
            } else if (sum < m) {
                lt++;
            } else {
                rt--;
                lt++;
                answer++;
            }
        }

        System.out.println(answer);
    }
}