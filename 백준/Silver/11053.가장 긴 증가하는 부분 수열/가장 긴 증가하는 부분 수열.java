import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        int[] maxDis = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scan.nextInt();
        }

        Arrays.fill(maxDis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (numbers[i] > numbers[j]) {
                    maxDis[i] = Math.max(maxDis[i], maxDis[j] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, maxDis[i]);
        }

        System.out.println(answer);
    }
}