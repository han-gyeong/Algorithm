import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        int[] arr = new int[20_000_000 + 1];

        for (int i = 0; i < n; i++) {
            arr[10_000_000 + scan.nextInt()]++;
        }

        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            sb.append(arr[10_000_000 + scan.nextInt()]).append(" ");
        }

        System.out.println(sb);
    }
}
