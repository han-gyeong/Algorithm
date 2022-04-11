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
        int k = Integer.parseInt(firstLine[2]);

        int[][] arr = new int[n][m];
        boolean[][][] path = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i <= k; i++) {
            path[0][0][i] = true;
        }

        System.out.println(BFS(arr, path, k));
    }

    public static int BFS(int[][] arr, boolean[][][] path, int limit) {
        Queue<Record> queue = new LinkedList<>();
        int level = 0;
        queue.add(new Record(0, 0, 0));

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
                        if (record.numOfCrushedWall == limit) {
                            // 깰 수 있는 벽 갯수의 최대치인 경우엔 0인 경우만 갈 수 있다.
                            if (arr[toX][toY] == 0 && !path[toX][toY][limit]) {
                                path[toX][toY][limit] = true;
                                queue.add(new Record(toX, toY, record.numOfCrushedWall));
                            }
                        } else {
                            // 깨야하는 벽을 만나고 아직 안간 길이면 한번 가보자
                            if (arr[toX][toY] == 1 && !path[toX][toY][record.numOfCrushedWall + 1]) {
                                path[toX][toY][record.numOfCrushedWall + 1] = true;
                                queue.add(new Record(toX, toY, record.numOfCrushedWall + 1));
                            } // 깰 필요가 없고 안간 길이면 한번 가보자
                            else if (arr[toX][toY] == 0 && !path[toX][toY][record.numOfCrushedWall]) {
                                path[toX][toY][record.numOfCrushedWall] = true;
                                queue.add(new Record(toX, toY, record.numOfCrushedWall));
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
        int numOfCrushedWall;

        public Record(int x, int y, int numOfCrushedWall) {
            this.x = x;
            this.y = y;
            this.numOfCrushedWall = numOfCrushedWall;
        }
    }
}