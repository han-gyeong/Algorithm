import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {-1, 0, 0, 1}; // 왼쪽, 아래, 위, 오른쪽
    static int[] dz = new int[] {-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[h][n][m];
        Queue<Coord> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.add(new Coord(i, j, k));
                    }
                }
            }
        }

        int answer = BFS(arr, queue);
        First:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        answer = -1;
                        break First;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static int BFS(int[][][] arr, Queue<Coord> queue) {
        int level = -1;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coord tmp = queue.poll();

                // 동서남북
                for (int j = 0; j < dx.length; j++) {
                    int toX = tmp.x + dx[j];
                    int toY = tmp.y + dy[j];
                    if (toX >= 0 && toX < arr[0].length && toY >= 0 && toY < arr[0][0].length && arr[tmp.z][toX][toY] == 0) {
                        arr[tmp.z][toX][toY] = 1;
                        queue.add(new Coord(tmp.z, toX, toY));
                    }
                }

                // 위아래
                for (int j = 0; j < dz.length; j++) {
                    int toZ = tmp.z + dz[j];
                    if (toZ >= 0 && toZ < arr.length && arr[toZ][tmp.x][tmp.y] == 0) {
                        arr[toZ][tmp.x][tmp.y] = 1;
                        queue.add(new Coord(toZ, tmp.x, tmp.y));
                    }
                }

            }
        }
        return level;
    }

    static class Coord {
        int z;
        int x;
        int y;

        public Coord(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}