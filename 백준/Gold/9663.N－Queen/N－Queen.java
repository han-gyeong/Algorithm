import java.util.Scanner;

public class Main {
    static int answer, n;
    static int[] check;

    public static void DFS(int index) {
        if (index == n) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                if (isPossible(index, i)) {
                    check[index] = i;
                    DFS(index + 1);
                }
            }
        }
    }

    public static boolean isPossible(int index, int value) {
        for (int i = index - 1; i >= 0; i--) {
            if (check[i] == value || Math.abs(index - i) == Math.abs(value - check[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        check = new int[n];
        DFS(0);

        System.out.println(answer);
    }
}