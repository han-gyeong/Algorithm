import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int[] answer = new int[v+1];

        Arrays.fill(answer, Integer.MAX_VALUE);

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
        }

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


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]).append('\n');
        }

        System.out.println(sb);
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