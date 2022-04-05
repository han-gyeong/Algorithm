import java.util.*;

public class Main {
    static int node, line, startNode;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        node = scan.nextInt();
        line = scan.nextInt();
        startNode = scan.nextInt();
        ch = new int[node + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        DFS(startNode, 1);
        System.out.println();

        ch = new int[node + 1];
        BFS(startNode);
    }

    public static void DFS(int beforeNum, int index) {
        ch[beforeNum] = 1;
        System.out.print(beforeNum + " ");

        if (index == node) {
            return;
        } else {
            graph.get(beforeNum).sort(Comparator.naturalOrder());
            for (int x : graph.get(beforeNum)) {
                if (ch[x] == 0) {
                    DFS(x, index + 1);
                }
            }
        }
    }

    public static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        ch[startNode] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int n = queue.poll();
                System.out.print(n + " ");
                graph.get(n).sort(Comparator.naturalOrder());
                for (int x : graph.get(n)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        queue.add(x);
                    }
                }
            }
        }
    }
}