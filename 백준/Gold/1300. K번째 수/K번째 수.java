import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long lt = 1;
        long rt = k; // X 값은 k를 넘지 않는다. B[k] = X;

        while (lt < rt) {
            // X값
            long mid = (lt + rt) / 2;

            // 앞에 몇개가 있는지 -> 인덱스
            long count = 0;
            for (int i = 1; i <= n; i++) {
                // 나보다 작은게 몇개 있는지
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        System.out.println(lt);
    }
}