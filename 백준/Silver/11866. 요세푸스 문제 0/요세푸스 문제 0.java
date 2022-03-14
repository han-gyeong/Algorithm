import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n = scan.nextInt();
        int target = scan.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        sb.append('<');
        while (!queue.isEmpty()) {
            for (int i = 0; i < target - 1; i++) {
                queue.add(queue.poll());
            }

            int num = queue.poll();
            if (queue.isEmpty()) {
                sb.append(num);
            } else {
                sb.append(num).append(", ");
            }
        }

        sb.append('>');
        System.out.println(sb);
    }
}