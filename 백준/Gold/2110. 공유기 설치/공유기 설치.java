import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        long lt = 0;
        long rt = arr[arr.length - 1] - arr[0] + 1;
        while (lt < rt) {
            long mid = (lt + rt) / 2;

            int router = find(arr, mid);

            if (router >= c) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        System.out.println(lt - 1);
    }

    public static int find(int[] arr, long minLength) {
        int lastHouse = arr[0];
        int router = 1;
        for (int i = 1; i < arr.length; i++) {
            if (lastHouse + minLength <= arr[i]) {
                router++;
                lastHouse = arr[i];
            }
        }

        return router;
    }
}