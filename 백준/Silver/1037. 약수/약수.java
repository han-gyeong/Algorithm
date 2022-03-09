import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        System.out.println(max * min);
    }
}