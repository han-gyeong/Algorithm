import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] distance = new long[n-1];
        long[] station = new long[n];
        long answer = 0;

        for (int i = 0; i < distance.length; i++) {
            distance[i] = scan.nextInt();
        }

        for (int i = 0; i < station.length; i++) {
            station[i] = scan.nextInt();
        }

        long minCost = station[0];
        for (int i = 0; i < distance.length; i++) {

            if (minCost > station[i]) {
                minCost = station[i];
            }

            answer += minCost * distance[i];
        }

        System.out.println(answer);
    }
}