import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Cost implements Comparable<Cost> {
        int vert;
        int cost;

        public Cost(int vert, int cost) {
            this.vert = vert;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cost o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] answer = new int[n+1];
        ArrayList<ArrayList<Cost>> graphs = new ArrayList<>();

        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graphs.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            graphs.get(from).add(new Cost(to, cost));
        }

        PriorityQueue<Cost> queue = new PriorityQueue<>();
        int from = scan.nextInt();
        int to = scan.nextInt();
        queue.add(new Cost(from, 0));
        answer[from] = 0;

        while (!queue.isEmpty()) {
            Cost tmp = queue.poll();
            if (tmp.cost > answer[tmp.vert]) {
                continue;
            }

            for (Cost ob : graphs.get(tmp.vert)) {
                if (answer[ob.vert] > tmp.cost + ob.cost) {
                    answer[ob.vert] = tmp.cost + ob.cost;
                    queue.offer(new Cost(ob.vert, tmp.cost + ob.cost));
                }
            }
        }

        System.out.println(answer[to]);
    }
}
