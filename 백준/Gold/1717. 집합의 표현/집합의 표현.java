import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        arr = new int[n+1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int method = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (method == 0) {
                union(a, b);
            } else {
                sb.append(find(a) == find(b) ? "YES" : "NO").append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            arr[parentA] = parentB;
        }
    }

    public static int find(int n) {
        if (arr[n] != n) {
            arr[n] = find(arr[n]);
        }

        return arr[n];
    }
}