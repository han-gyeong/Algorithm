import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] dx = new int[] {0, -1, 1}; // 마지막은 *2를 위한 자리
    static int[] cost = new int[] {0, 1, 1};
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        PriorityQueue<Move> queue = new PriorityQueue<>();
        queue.add(new Move(n, 0));
        arr[n] = 0;

        while (!queue.isEmpty()) {
            Move move = queue.poll();

            if (arr[move.location] < move.price) {
                continue;
            }

            dx[0] = move.location;
            for (int i = 0; i < dx.length; i++) {
                int to = move.location + dx[i];
                int price = move.price + cost[i];
                if (to >= 0 && to <= 100000 && arr[to] > price) {
                    arr[to] = price;
                    queue.add(new Move(to, price));
                }
            }
        }

        System.out.println(arr[k]);
    }

    static class Move implements Comparable<Move> {
        int location;
        int price;

        public Move(int location, int price) {
            this.location = location;
            this.price = price;
        }

        @Override
        public int compareTo(Move o) {
            return this.price - o.price;
        }
    }
}