import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] ch;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int computer = scan.nextInt();
        int line = scan.nextInt();
        ch = new int[computer + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        ch[1] = 1;
        DFS(1, 1, graph);

        int answer = 0;
        for (int i = 2; i < ch.length; i++) {
            if (ch[i] == 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void DFS(int index, int before, ArrayList<ArrayList<Integer>> graph) {
        if (index == ch.length) {
            return;
        } else {
            for (int x : graph.get(before)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    DFS(index + 1, x, graph);
                }
            }
        }
    }

}