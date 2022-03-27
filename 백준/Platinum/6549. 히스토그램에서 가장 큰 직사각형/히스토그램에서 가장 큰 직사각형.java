// 참고: https://st-lab.tistory.com/255

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(0, n-1)).append('\n');
        }

        System.out.println(sb);
    }

    private static long getArea(int from, int to) {
        if (from == to) {
            return arr[from];
        }

        int mid = (from + to) / 2;
        long leftArea = getArea(from, mid);
        long rightArea = getArea(mid + 1, to);

        return Math.max(Math.max(leftArea, rightArea), getMidArea(from, mid, to));
    }

    private static long getMidArea(int from, int mid, int to) {
        long answer = arr[mid];
        int height = arr[mid];
        int toLeft = mid, toRight = mid;

        while (toLeft > from && toRight < to) {
            if (arr[toLeft - 1] < arr[toRight + 1]) {
                toRight++;
                height = Math.min(height, arr[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, arr[toLeft]);
            }
            answer = Math.max(answer, (long) height * (toRight - toLeft + 1));
        }

        while (toRight < to) {
            toRight++;
            height = Math.min(height, arr[toRight]);
            answer = Math.max(answer, (long) height * (toRight - toLeft + 1));
        }

        while (toLeft > from) {
            toLeft--;
            height = Math.min(height, arr[toLeft]);
            answer = Math.max(answer, (long) height * (toRight - toLeft + 1));
        }

        return answer;
    }
}