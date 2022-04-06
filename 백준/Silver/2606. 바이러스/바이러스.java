import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        int[] ch = new int[computer + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int x : graph.get(n)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    queue.add(x);
                }
            }
        }

        int answer = 0;
        for (int i = 2; i < ch.length; i++) {
            if (ch[i] == 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}