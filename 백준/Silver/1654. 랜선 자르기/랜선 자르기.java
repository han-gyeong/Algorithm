import java.util.Scanner;

public class Main {
    static int[] cables;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        cables = new int[k];

        long sum = 0;

        for (int i = 0; i < k; i++) {
            cables[i] = scan.nextInt();
            sum += cables[i];
        }

        long from = 0;
        long to = (sum / n) + 1;

        while (from < to) {
            long mid = (from + to) / 2;

            if (possibleNumOfCables(mid) >= n) {
                from = mid + 1;
            } else {
                to = mid;
            }
        }

        System.out.println(from - 1);
    }

    private static int possibleNumOfCables(long length) {
        if (length == 0) {
            return 0;
        }

        int number = 0;
        for (int cable : cables) {
            number += (cable / length);
        }

        return number;
    }

}