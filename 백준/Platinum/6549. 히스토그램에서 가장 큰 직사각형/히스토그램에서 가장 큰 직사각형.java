import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            System.out.println(getArea(0, n-1));
        }
    }

    private static long getArea(int from, int to) {
        if (from == to) {
            return arr[from];
        }

        int mid = (from + to) / 2;
        long leftArea = getArea(from, mid);
        long rightArea = getArea(mid + 1, to);

        long answer = Math.max(leftArea, rightArea);

        long midArea = getMidArea(from, mid, to);

        return Math.max(answer, midArea);
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