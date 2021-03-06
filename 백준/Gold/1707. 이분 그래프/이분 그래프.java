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

            // 끊겨있는 그래프가 있을수도 있으니, ch 배열 확인해서 0인거(안돈거) 있으면 거기를 시작으로 다시
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
        ch[startPoint] = -1; // -1 과 1 로 구분

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

                    ch[x] = ch[tmp] * -1;
                }
            }
        }
        return "YES";
    }
}