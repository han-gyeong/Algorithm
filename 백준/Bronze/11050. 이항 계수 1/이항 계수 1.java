import java.util.Scanner;

public class Main {
    static int[] factorial = new int[11];

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        factorial(10);

        int answer = factorial(a) / (factorial(a-b) * factorial(b));
        System.out.println(answer);

    }

    public static int factorial(int n) {
        if (factorial[n] < 0) {
            return factorial[n];
        }

        if (n == 1 || n == 0) {
            factorial[n] = 1;
        } else {
            factorial[n] = n * factorial(n-1);
        }

        return factorial[n];
    }
}