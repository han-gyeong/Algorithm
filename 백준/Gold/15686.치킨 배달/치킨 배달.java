import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m, answer;

    static int[][] map;
    static int[] check;
    static List<Point> shop;
    static List<Point> house;


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void DFS(int num, int at) {
        if (num == m) {
            int total_sum = 0;
            for (Point x : house) {
                int tmp = 100000;
                for (int j : check) {
                    Point point = shop.get(j);
                    tmp = Math.min(tmp, ((Math.abs(x.x - point.x)) + (Math.abs(x.y - point.y))));
                }
                total_sum += tmp;
            }
            answer = Math.min(answer, total_sum);
        } else {
            for (int i = at; i < shop.size(); i++) {
                check[num] = i;
                DFS(num + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        map = new int[n][n];
        shop = new ArrayList<>();
        house = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
                if (map[i][j] == 2) {
                    shop.add(new Point(i, j));
                } else if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                }
            }
        }

        check = new int[m];
        DFS(0, 0);
        System.out.println(answer);

    }
}