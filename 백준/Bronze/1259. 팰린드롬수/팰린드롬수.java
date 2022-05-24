import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            String answer = "yes";
            String[] split = input.split("");

            int lt = 0;
            int rt = split.length - 1;

            while (lt < rt) {
                if (!split[lt].equals(split[rt])) {
                    answer = "no";
                    break;
                }

                lt++;
                rt--;
            }

            System.out.println(answer);
        }

    }
}
