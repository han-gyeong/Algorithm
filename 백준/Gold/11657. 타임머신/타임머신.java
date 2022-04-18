import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 도시의 개수
        int m = scan.nextInt(); // 노선 개수
        long[] arr = new long[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;

        ArrayList<Road> roads = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int price = scan.nextInt();
            roads.add(new Road(from, to, price));
        }

        boolean isLoop = false;

        // V-1 번으로 최단거리 탐색이 완료, 1번 더해서 음수 가중치가 있는지 확인하기
        for (int i = 0; i < n; i++) {
            for (Road road : roads) {
                if (arr[road.from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (arr[road.to] > arr[road.from] + road.price) {
                    arr[road.to] = arr[road.from] + road.price;

                    if (i == n-1) {
                        isLoop = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isLoop) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                if (arr[i] == Integer.MAX_VALUE) {
                    sb.append(-1);
                } else {
                    sb.append(arr[i]);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    static class Road {
        int from;
        int to;
        int price;

        public Road(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
}