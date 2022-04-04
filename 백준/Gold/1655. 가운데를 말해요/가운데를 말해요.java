import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(tmp);
            }

            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.println(sb);
    }
}