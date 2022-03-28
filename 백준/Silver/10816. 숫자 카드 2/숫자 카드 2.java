import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append((upper(arr, key) - lower(arr, key))).append(" ");
        }

        System.out.println(sb);
    }

    public static int lower(int[] arr, int target) {
        int from = 0;
        int to = arr.length;

        while (from < to) {
            int mid = (from + to) / 2;

            if (target <= arr[mid]) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return from;
    }

    public static int upper(int[] arr, int target) {
        int from = 0;
        int to = arr.length;

        while (from < to) {
            int mid = (from + to) / 2;

            if (target < arr[mid]) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }

        return from;
    }
}