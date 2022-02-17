import java.util.Scanner;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int[][] score;
    static int[] ch;
    static int n;

    public static void DFS(int ind, int at) {
        if (ind == n / 2) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (ch[j] == 1) {
                            a += score[i][j];
                        }
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        if (ch[j] == 0) {
                            b += score[i][j];
                        }
                    }
                }
            }
            answer = Math.min(answer, Math.abs(a-b));
        } else {
            for (int i = at; i < n; i++) {
                ch[i] = 1;
                DFS(ind + 1, i + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        score = new int[n][n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score[i][j] = scan.nextInt();
            }
        }

        DFS(0, 0);

        System.out.println(answer);
    }
}