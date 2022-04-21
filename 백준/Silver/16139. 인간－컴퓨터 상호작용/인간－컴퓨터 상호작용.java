import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArray = s.toCharArray();
        int[][] answer = new int[26][s.length()];

        int n = Integer.parseInt(br.readLine());
        calculate(charArray, answer);

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char alpha = st.nextToken().charAt(0);

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int left = answer[alpha - 97][to];
            int right = (from - 1 < 0) ? 0 : answer[alpha - 97][from - 1];

            sb.append(left - right).append('\n');
        }

        System.out.println(sb);
    }

    public static void calculate(char[] target, int[][] answer) {
        for (int i = 97; i <= 122; i++) {

            // 첫 글자가 ASCII 의 I와 같은지(같은 알파벳인지)
            answer[i - 97][0] = (target[0] == i) ? 1 : 0;
            for (int j = 1; j < target.length; j++) {
                answer[i - 97][j] = answer[i - 97][j - 1];
                if (target[j] == i) {
                    answer[i - 97][j]++;
                }
            }
        }
    }
}