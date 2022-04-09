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

                // + 1 이 K 보다 커질리가 없다. 못해도 같아야 한다.
                if (tmp + 1 <= k && arr[tmp + 1] == 0) {
                    arr[tmp + 1] = 1;
                    queue.add(tmp + 1);
                }

                // N이 K 보다 큰 경우 뒤로도 가야하니까, 0보다 크도록.
                if (tmp - 1 >= 0 && arr[tmp - 1] == 0) {
                    arr[tmp - 1] = 1;
                    queue.add(tmp - 1);
                }

                // K 보다 더 커졌을때 가능한 경우도 있으니, 범위를 <= K 가 아니라 <= 100000
                if (tmp * 2 <= 100000 && arr[tmp * 2] == 0) {
                    arr[tmp * 2] = 1;
                    queue.add(tmp * 2);
                }
            }
        }
        return level;
    }
}