import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i-1];
        }

        int answer = 0;

        for (int i : arr) {
            answer += i;
        }

        System.out.println(answer);
    }
}