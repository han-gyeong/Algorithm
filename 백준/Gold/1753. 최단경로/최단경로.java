import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int e = scan.nextInt();
        int start = scan.nextInt();
        int[] answer = new int[v+1];

        Arrays.fill(answer, Integer.MAX_VALUE);

        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
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


        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]);
        }
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