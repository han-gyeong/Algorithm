import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int lt = 1;
        int rt = 1;
        int sum = 1;
        int answer = 0;

        while (lt <= rt) {
            if (sum < n) {
                sum += ++rt;
            } else {
                if (sum == n) {
                    answer++;
                }

                sum -= lt++;
            }
        }

        System.out.println(answer);
    }
}
