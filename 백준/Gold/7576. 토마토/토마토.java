import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{-1, 0, 0, 1}; // 왼쪽, 아래, 위, 오른쪽

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        Queue<Coord> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new Coord(i, j));
                }
            }
        }

        int answer = BFS(arr, queue);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    answer = -1;
                }
            }
        }

        System.out.println(answer);
    }

    public static int BFS(int[][] arr, Queue<Coord> queue) {
        int level = -1;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coord tmp = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int toX = tmp.x + dx[j];
                    int toY = tmp.y + dy[j];
                    if (toX >= 0 && toX < arr.length && toY >= 0 && toY < arr[0].length && arr[toX][toY] == 0) {
                        arr[toX][toY] = 1;
                        queue.add(new Coord(toX, toY));
                    }
                }
            }
        }

        return level;
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}