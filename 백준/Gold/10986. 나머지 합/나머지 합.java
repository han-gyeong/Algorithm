import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        // 값 입력 받아서 누적합 만들기
        int sum = 0;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % m;
            dp[sum]++;
        }

        /*
        (sum[i] - sum[j]) % M == 0 -> sum[i] % M - sum[j] % M == 0 -> sum[i] % M == sum[j] % M
        나머지가 같은 애들 중 2개를 뽑는 조합
         */
        long answer = dp[0];
        for (int i = 0; i < m; i++) {
            answer += ((long) dp[i] * (dp[i] - 1)) / 2;
        }

        System.out.println(answer);
    }
}