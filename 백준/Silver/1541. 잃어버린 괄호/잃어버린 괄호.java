import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] sp = s.split("-");
        for (int i = 0; i < sp.length; i++) {
            if (sp[i].contains("+")) {
                int sum = 0;
                String[] split = sp[i].split("\\+");
                for (String s2 : split) {
                    sum += Integer.parseInt(s2);
                }
                sp[i] = String.valueOf(sum);
            }
        }

        int answer = Integer.parseInt(sp[0]);
        for (int i = 1; i < sp.length; i++) {
            answer -= Integer.parseInt(sp[i]);
        }

        System.out.println(answer);

    }
}