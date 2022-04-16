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
                int cost = Integer.parseInt(st.nextToken()) * 2;

                // 꼭 지나가야 하는 간선의 경우에 COST를 홀수로 둔다.
                // 짝 + 짝 = 짝, 짝 + 홀 = 홀 이라는 것을 이용한다.
                if (((from == g) && (to == h)) || ((from == h) && (to == g))) {
                    cost--;
                }

                graph.get(from).add(new Vertex(to, cost));
                graph.get(to).add(new Vertex(from, cost));
            }

            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int dest = Integer.parseInt(br.readLine());
                long count = count(startPoint, dest, graph);

                // 지나가야하는 간선을 지나갔다면 거리의 수는 홀수일 것이므로 홀수면 지나갔다는것을 알 수 있다!
                if (count % 2 == 1) {
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
        // 원래 MAX_VALUE 로 설정했는데, 홀수라서 더해지는 경우도 존재할 수 있어서, 짝수가 되도록 /2 *2
        Arrays.fill(answer, Integer.MAX_VALUE / 2 * 2);

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