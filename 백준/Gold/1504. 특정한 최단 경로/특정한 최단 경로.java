import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Vertex(to, cost));
            graph.get(to).add(new Vertex(from, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        long trace1 = count(1, one, graph);
        long trace2 = count(one, two, graph);
        long trace3 = count(two, v, graph);

        long trace4 = count(1, two, graph);
        long trace5 = count(one, v, graph);

        long case1 = trace1 + trace2 + trace3;
        long case2 = trace4 + trace2 + trace5;
        System.out.println((case1 >= 200000 * 1000 && case2 >= 200000 * 1000) ? -1 : Math.min(case1, case2));
    }

    public static int count(int start, int end, ArrayList<ArrayList<Vertex>> graph) {
        int[] answer = new int[v + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        answer[start] = 0;
        queue.add(new Vertex(start, 0));

        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();

            if (answer[poll.vertex] < poll.cost) {
                continue;
            }

            for (Vertex tmp : graph.get(poll.vertex)) {
                if (answer[tmp.vertex] > poll.cost + tmp.cost) {
                    answer[tmp.vertex] = poll.cost + tmp.cost;
                    queue.add(new Vertex(tmp.vertex, poll.cost + tmp.cost));
                }
            }
        }

        return answer[end];
    }

    public static class Vertex implements Comparable<Vertex> {
        int vertex;
        int cost;

        public Vertex(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }
}