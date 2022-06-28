import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String answer = "";
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == 1) {
                answer = "ascending";
            } else if (diff == -1) {
                answer = "descending";
            } else {
                answer = "mixed";
                break;
            }
        }

        System.out.println(answer);
    }
}