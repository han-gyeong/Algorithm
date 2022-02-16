import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int[] Callone = new int[41];
        Callone[0] = 0;
        Callone[1] = 1;
        Callone[2] = 1;

        int[] Callzero = new int[41];
        Callzero[0] = 1;
        Callzero[1] = 0;
        Callzero[2] = 1;

        for (int i = 3; i < Callone.length; i++) {
            Callone[i] = Callone[i-1] + Callone[i-2];
            Callzero[i] = Callzero[i-1] + Callzero[i-2];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Callzero[arr[i]] + " " + Callone[arr[i]]);
        }

    }
}