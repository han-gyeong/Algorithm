import java.util.Scanner;

public class Main {
    static StringBuffer sb;
    public static void Hanoi(int n, int start, int to, int other) {
        if (n == 1) {
            sb.append(start + " " + to).append('\n');
            return;
        }

        Hanoi(n-1, start, other, to);
        sb.append(start + " " + to).append('\n');
        Hanoi(n-1, other, to, start);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        sb = new StringBuffer();
        int n = scan.nextInt();

        sb.append((int) Math.pow(2, n) - 1).append('\n');
        Hanoi(n, 1, 3, 2);

        System.out.println(sb);
    }
}