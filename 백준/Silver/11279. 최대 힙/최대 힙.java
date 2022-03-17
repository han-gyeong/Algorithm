import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int input = scan.nextInt();
            if (input == 0) {
                System.out.println(priorityQueue.isEmpty() ? 0 : priorityQueue.poll());
            } else {
                priorityQueue.offer(input);
            }
        }
    }
}