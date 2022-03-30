import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            long pow = 1;

            for (int j = 0; j < b; j++) {
                pow = (pow * a) % 10;
            }

            System.out.println(pow == 0 ? 10 : pow);
        }
    }
}