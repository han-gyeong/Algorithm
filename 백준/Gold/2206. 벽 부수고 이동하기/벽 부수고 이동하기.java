import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        int[][] arr = new int[n][m];
        boolean[][][] path = new boolean[n][m][2]; // X, Y, 벽 안부수고 방문/부수고 방문
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(BFS(arr, path));
    }

    public static int BFS(int[][] arr, boolean[][][] path) {
        Queue<Record> queue = new LinkedList<>();
        int level = 0;
        path[0][0][0] = true;
        path[0][0][1] = true;
        queue.add(new Record(0, 0, false));

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Record record = queue.poll();
                if (record.x == arr.length - 1 && record.y == arr[0].length - 1) {
                    return level;
                }

                for (int j = 0; j < dx.length; j++) {
                    int toX = record.x + dx[j];
                    int toY = record.y + dy[j];
                    if (toX >= 0 && toX < arr.length && toY >= 0 && toY < arr[0].length) {
                        if (record.isCrushed) {
                            if (arr[toX][toY] == 0 && !path[toX][toY][1]) {
                                path[toX][toY][1] = true;
                                queue.add(new Record(toX, toY, true));
                            }
                        } else {
                            if (arr[toX][toY] == 1 && !path[toX][toY][1]) {
                                path[toX][toY][1] = true;
                                queue.add(new Record(toX, toY, true));
                            } else if (arr[toX][toY] == 0 && !path[toX][toY][0]) {
                                path[toX][toY][0] = true;
                                queue.add(new Record(toX, toY, false));
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    static class Record {
        int x;
        int y;
        boolean isCrushed;

        public Record(int x, int y, boolean isCrushed) {
            this.x = x;
            this.y = y;
            this.isCrushed = isCrushed;
        }
    }
}