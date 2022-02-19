import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= value; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 15746;
        }

        System.out.println(arr[value]);
    }
}