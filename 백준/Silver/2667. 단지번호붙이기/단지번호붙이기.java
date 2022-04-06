import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{-1, 0, 0, 1}; // 왼쪽, 아래, 위, 오른쪽
    static int[][] arr, ch;
    static int number, count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        arr = new int[number][];
        ch = new int[number][number];

        for (int i = 0; i < number; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (ch[i][j] == 0 && arr[i][j] == 1) {
                    count = 1; // 단지 내의 아파트 갯수 count 초기화
                    ch[i][j] = 1;
                    
                    DFS(i, j);
                    answer.add(count);
                }
            }
        }

        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        for (Integer x : answer) {
            System.out.println(x);
        }
    }

    private static void DFS(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int toX = x + dx[i];
            int toY = y + dy[i];
            if (toX >= 0 && toX < number && toY >= 0 && toY < number && arr[toX][toY] == 1 && ch[toX][toY] == 0) {
                ch[toX][toY] = 1;
                count++;
                DFS(toX, toY);
            }
        }
    }
}