import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[][] palindrome;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 1일 경우는 회문 문자열, 0일 경우는 회문 문자열 X
        palindrome = new int[n+1][n+1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(palindrome[i], -1);
            palindrome[i][i] = 1;
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(isPalindrome(tmp[0], tmp[1])).append('\n');
        }

        System.out.println(sb);
    }

    private static int isPalindrome(int s, int e) {
        if (s >= e) {
            return 1;
        }

        if (palindrome[s][e] != -1) {
            return palindrome[s][e];
        }

        if (arr[s - 1] == arr[e - 1]) {
            return palindrome[s][e] = isPalindrome(s + 1, e - 1);
        }

        return 0;
    }
}
