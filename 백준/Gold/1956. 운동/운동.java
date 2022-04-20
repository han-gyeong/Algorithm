import java.util.Scanner;

public class Main {
    public static final int INF = 40_000_001;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int e = scan.nextInt();

        int[][] arr = new int[v+1][v+1];
        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                arr[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            arr[from][to] = cost;
        }
        
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if (arr[j][k] > arr[j][i] + arr[i][k]) {
                        if (arr[j][i] == INF || arr[i][k] == INF) {
                            continue;
                        }

                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            answer = Math.min(answer, arr[i][i]);
        }

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
}