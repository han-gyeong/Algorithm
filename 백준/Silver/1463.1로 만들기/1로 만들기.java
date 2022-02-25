import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 6 == 0) {
                arr[i] = Math.min(arr[i/3], Math.min(arr[i/2], arr[i-1])) + 1;
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i/3], arr[i-1]) + 1;
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i/2], arr[i-1]) + 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        System.out.println(arr[n]);
    }
}