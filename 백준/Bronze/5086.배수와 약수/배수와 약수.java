import java.util.Scanner;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(is(a, b));
        }

    }

    public static String is(int a, int b) {
        if (a > b) {
            if (a % b == 0) {
                return "multiple";
            }
        } else {
            if (b % a == 0) {
                return "factor";
            }
        }
        return "neither";
    }
}