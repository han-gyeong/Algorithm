import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][][] arr;
    public static int w(int a, int b, int c) {
        if (arr[a][b][c] > 0) {
            return arr[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return arr[a][b][c] = 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return arr[a][b][c] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[51][51][51];
        StringBuffer sb = new StringBuffer();
        while (true) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(" + a + ", " + b + ", " + c + ") = ");

            if (a < 0) {
                a = 0;
            }

            if (b < 0) {
                b = 0;
            }

            if (c < 0) {
                c = 0;
            }

            sb.append(w(a,b,c)).append('\n');
        }
        System.out.println(sb);
    }
}