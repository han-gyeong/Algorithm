import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr, path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        path = new int[n + 1];

        arr[0] = 0;
        arr[1] = 0;

        path[0] = 0;
        path[1] = 0;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && arr[i] > arr[i/2] + 1) {
                arr[i] = arr[i/2] + 1;
                path[i] = i/2;
            }
            
            if (i % 3 == 0 && arr[i] > arr[i/3] + 1) {
                arr[i] = arr[i/3] + 1;
                path[i] = i/3;
            }
        }

        System.out.println(arr[n]);
        StringBuilder sb = new StringBuilder();

        int index = n;
        while (true) {
            if (index == 0) {
                break;
            }

            sb.append(index + " ");
            index = path[index];
        }

        System.out.println(sb);
    }
}