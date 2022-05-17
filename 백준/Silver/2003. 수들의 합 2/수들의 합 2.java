import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int lt = 0;
        int sum = 0;

        int answer = 0;
        for (int rt = 0; rt < array.length; rt++) {
            sum += array[rt];

            while (lt <= rt && sum >= m) {
                if (sum == m) {
                    answer++;
                }

                sum -= array[lt++];
            }
        }

        System.out.println(answer);
    }
}