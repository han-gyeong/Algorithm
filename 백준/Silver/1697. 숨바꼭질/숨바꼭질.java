import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        System.out.println(BFS(n, k));

    }

    public static int BFS(int n, int k) {
        int level = -1;
        int[] arr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                if (tmp == k) {
                    return level;
                }

                if (tmp + 1 <= k && arr[tmp + 1] == 0) {
                    arr[tmp + 1] = 1;
                    queue.add(tmp + 1);
                }

                if (tmp - 1 >= 0 && arr[tmp - 1] == 0) {
                    arr[tmp - 1] = 1;
                    queue.add(tmp - 1);
                }

                if (tmp * 2 <= 100000 && arr[tmp * 2] == 0) {
                    arr[tmp * 2] = 1;
                    queue.add(tmp * 2);
                }
            }
        }
        return level;
    }
}