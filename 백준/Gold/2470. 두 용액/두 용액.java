import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = n - 1;
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                answer[0] = arr[lt];
                answer[1] = arr[rt];
            }

            if (sum == 0) {
                break;
            }

            if (sum > 0) {
                rt--;
            } else {
                lt++;
            }
        }

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}