import java.util.Scanner;

public class Main {
    static int[] trees;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        trees = new int[k];

        long min = 0;
        long max = 0;

        for (int i = 0; i < k; i++) {
            trees[i] = scan.nextInt();
            max = Math.max(max, trees[i]);
        }

        while (min < max) {
            long mid = (min + max) / 2;

            long totalLengthOfCutTree = 0;
            for (int tree : trees) {
                if (mid > tree) {
                    continue;
                }
                totalLengthOfCutTree += (tree - mid);
            }

            if (totalLengthOfCutTree >= n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);
    }
}