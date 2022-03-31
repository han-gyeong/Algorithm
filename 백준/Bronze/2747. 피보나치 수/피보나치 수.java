import java.util.Scanner;

public class Main {
    static int[] fibonacci;

    public static void main(String[] args) throws Exception {
        fibonacci = new int[46];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (fibonacci[n] == 0) {
            fibonacci[n] = fibonacci(n-1) + fibonacci(n-2);
        }

        return fibonacci[n];
    }
}