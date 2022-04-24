import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;
        int answer = 100001;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];

            while (sum >= s && lt <= rt) {
                answer = Math.min(answer, rt  - lt + 1);
                sum -= arr[lt];
                lt++;
            }
        }

        System.out.println(answer == 100001 ? 0 : answer);
    }
}