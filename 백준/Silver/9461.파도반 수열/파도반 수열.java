import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] arr = new long[101];

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= 100; i++) {
            arr[i] = arr[i-3] + arr[i-2];
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            sb.append(arr[scan.nextInt()]).append('\n');
        }

        System.out.println(sb);
    }
}