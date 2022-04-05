import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        double pow = Math.pow(n, 2);
        System.out.println(pow * Math.PI);
        System.out.println(2 * pow);
    }
}