import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[] {0, 1, -1, 0};
    static int[] dy = new int[] {-1, 0, 0, 1}; // 왼쪽, 아래, 위, 오른쪽
    static int[][] arr, ch;
    static int number;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        arr = new int[number][];

        for (int i = 0; i < number; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int group = 0;
        ArrayList<Integer> answers = new ArrayList<>();
        ch = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (ch[i][j] == 0 && arr[i][j] == 1) {
                    group++;
                    ch[i][j] = 1;
                    answers.add(BFS(i, j));
                }
            }
        }

        answers.sort(Comparator.naturalOrder());
        System.out.println(group);
        for (Integer answer : answers) {
            System.out.println(answer);
        }
    }

    private static int BFS(int x, int y) {
        int answer = 1;
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(x, y));

        while (!queue.isEmpty()) {
            Coord coord = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int xC = coord.x + dx[i];
                int yC = coord.y + dy[i];
                if (xC >= 0 && xC < number && yC >= 0 && yC < number && arr[xC][yC] == 1 && ch[xC][yC] == 0) {
                    ch[xC][yC] = 1;
                    queue.add(new Coord(xC, yC));
                    answer++;
                }
            }
        }

        return answer;
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