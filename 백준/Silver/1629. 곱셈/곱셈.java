import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(arr[0], arr[1]));
    }

    public static long solution(int bottom, int top) {
        if (top == 1) {
            return bottom % arr[2];
        } else {
            long half = solution(bottom, top / 2);

            if (top % 2 == 0) {
                return (half * half % arr[2]);
            } else {
                return ((half * half % arr[2]) * (bottom % arr[2])) % arr[2];
            }
        }
    }
}