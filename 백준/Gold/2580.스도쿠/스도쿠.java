import java.util.*;

public class Main {
    static int[][] sudoku;
    static int size;
    static boolean isFinish = false;
    static ArrayList<Coord> zeros;

    public static void DFS(int index) {
        if (index == zeros.size()) {
            isFinish = true;
        } else {
            Coord coord = zeros.get(index);
            int x = coord.x;
            int y = coord.y;
            for (int i = 1; i <= size; i++) {
                if (isPossible(x, y, i)) {
                    sudoku[x][y] = i;
                    DFS(index + 1);
                    if (isFinish) {
                        break;
                    }
                    sudoku[x][y] = 0;
                }
            }

        }
    }

    public static boolean isPossible(int x, int y, int value) {
        for (int i = 0; i < size; i++) {
            if (sudoku[x][i] == value || sudoku[i][y] == value) {
                return false;
            }
        }

        int xRange = (x / 3) * 3;
        int yRange = (y / 3) * 3;

        for (int i = xRange; i < xRange + 3; i++) {
            for (int j = yRange; j < yRange + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }
        
        return true;
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        size = 9;
        sudoku = new int[size][size];
        zeros = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sudoku[i][j] = scan.nextInt();
                if (sudoku[i][j] == 0) {
                    zeros.add(new Coord(i, j));
                }
            }
        }

        DFS(0);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(sudoku[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}