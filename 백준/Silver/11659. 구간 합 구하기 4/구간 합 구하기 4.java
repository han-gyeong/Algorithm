import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] arr = new int[n+1];
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
            arr[i] += arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            System.out.println(arr[to] - arr[from - 1]);
        }
    }
}