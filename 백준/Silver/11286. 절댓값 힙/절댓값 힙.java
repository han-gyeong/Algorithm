import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Value> queue = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();

        while (n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                sb.append(queue.isEmpty() ? 0 : queue.poll().value).append('\n');
            } else {
                queue.add(new Value(Math.abs(value), value));
            }
        }

        System.out.println(sb);
    }

    static class Value implements Comparable<Value> {
        int abs;
        int value;

        public Value(int abs, int value) {
            this.abs = abs;
            this.value = value;
        }

        @Override
        public int compareTo(Value v) {
            if (this.abs == v.abs) {
                return this.value - v.value;
            } else {
                return this.abs - v.abs;
            }
        }
    }
}