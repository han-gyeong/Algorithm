import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int value = scan.nextInt();
        int[] change = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            change[i] = scan.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            answer += (value / change[i]);
            value %= change[i];
        }

        System.out.println(answer);
    }
}