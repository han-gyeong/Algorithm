import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v, e, t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (--n >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine(), " ");
            int startPoint = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(from).add(new Vertex(to, cost));
                graph.get(to).add(new Vertex(from, cost));
            }

            int gtoh = graph.get(g).stream().filter(o -> o.vertex == h).findFirst().get().cost;

            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int tmp = 0;
                int dest = Integer.parseInt(br.readLine());
                long startToDest = count(startPoint, dest, graph);

                long startToGToDest = count(startPoint, g, graph) + gtoh + count(h, dest, graph);
                long startToHToDest = count(startPoint, h, graph) + gtoh + count(g, dest, graph);

                if (startToDest >= Math.min(startToGToDest, startToHToDest)) {
                    answer.add(dest);
                }
            }

            answer.sort(Comparator.naturalOrder());
            for (Integer x : answer) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static long count(int start, int end, ArrayList<ArrayList<Vertex>> graph) {
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