import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < sp.length; i++) {
            int tmp = 0;

            String[] split = sp[i].split("\\+");
            for (int j = 0; j < split.length; j++) {
                tmp += Integer.parseInt(split[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }

        }

        System.out.println(sum);

    }
}