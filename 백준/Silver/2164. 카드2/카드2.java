import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (true) {
            if (queue.size() == 1) {
                break;
            } else {
                queue.poll();
                queue.add(queue.poll());
            }
        }

        System.out.println(queue.poll());
    }
}