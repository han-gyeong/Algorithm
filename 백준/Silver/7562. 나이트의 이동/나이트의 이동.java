import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[] {-2, -2, 2, 2, -1, 1, -1, 1};
    static int[] dy = new int[] {-1, 1, -1, 1, -2, -2, 2, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[][] ch = new int[size][size];

            String[] input = br.readLine().split(" ");
            int fromX = Integer.parseInt(input[0]);
            int fromY = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int toX = Integer.parseInt(input[0]);
            int toY = Integer.parseInt(input[1]);

            int answer = BFS(ch, fromX, fromY, toX, toY);
            System.out.println(answer);
        }
    }

    public static int BFS(int[][] ch, int fromX, int fromY, int toX, int toY) {
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(fromX, fromY));
        ch[fromX][fromY] = 1;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coord coord = queue.poll();
                if (coord.x == toX && coord.y == toY) {
                    return level;
                }

                for (int j = 0; j < dx.length; j++) {
                    int x = coord.x + dx[j];
                    int y = coord.y + dy[j];
                    if (x >= 0 && x < ch.length && y >= 0 && y < ch[0].length && ch[x][y] == 0) {
                        ch[x][y] = 1;
                        queue.add(new Coord(x, y));
                    }
                }
            }
            level++;
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