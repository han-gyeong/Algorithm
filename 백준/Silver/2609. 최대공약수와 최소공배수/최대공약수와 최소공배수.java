import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int one = scan.nextInt();
        int two = scan.nextInt();
        int GCD = 1;

        for (int i = 2; i <= Math.min(one, two); i++) {
            if ((one % i == 0) && (two % i == 0)) {
                GCD = Math.max(GCD, i);
            }
        }

        System.out.println(GCD);
        System.out.println((one * two) / GCD);
    }
}