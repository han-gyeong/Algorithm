import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        long lt = 1;
        long rt = k;
        
        while (lt < rt) {
            long mid = (lt + rt) / 2;

            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        System.out.println(lt);
    }
}