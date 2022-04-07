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

        String[][] arr = new String[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        System.out.println(BFS(arr));
    }

    private static int BFS(String[][] arr) {
        Queue<Coord> queue = new LinkedList<>();
        int[][] ch = new int[arr.length][arr[0].length];
        boolean isFinish = false;

        ch[0][0] = 1;
        queue.add(new Coord(0, 0));
        int level = 0;

        while (!queue.isEmpty() && !isFinish) {
            int size = queue.size();
            level++;
            for (int k = 0; k < size; k++) {
                Coord coord = queue.poll();
                if (coord.x == arr.length - 1 && coord.y == arr[0].length - 1) {
                    isFinish = true;
                    break;
                }

                for (int i = 0; i < dx.length; i++) {
                    int toX = coord.x + dx[i];
                    int toY = coord.y + dy[i];
                    if (toX >= 0 && toX < arr.length && toY >= 0 && toY < arr[0].length && arr[toX][toY].equals("1") && ch[toX][toY] == 0) {
                        ch[toX][toY] = 1;
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