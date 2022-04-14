import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int[] ch = new int[v + 1];
            String answer = "YES";
            for (int i = 1; i < ch.length; i++) {
                if (ch[i] == 0) {
                    String tmp = BFS(graph, ch, i);
                    if (tmp.equals("NO")) {
                        answer = "NO";
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static String BFS(ArrayList<ArrayList<Integer>> graph, int[] ch, int startPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        ch[startPoint] = 1; // 1은 RED 2는 BLACK

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                for (int x : graph.get(tmp)) {
                    if (ch[tmp] == ch[x]) {
                        return "NO";
                    }

                    if (ch[x] == 0) {
                        queue.add(x);
                    }

                    if (ch[tmp] == 1) {
                        ch[x] = 2;
                    } else {
                        ch[x] = 1;
                    }
                }
            }
        }
        return "YES";
    }
}