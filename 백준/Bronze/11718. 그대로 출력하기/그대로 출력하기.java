import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        char[] chars = new char[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        br.read(chars);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\n') {
                sb.append('\n');
                continue;
            }

            if (chars[i] == 0) {
                break;
            }

            sb.append(chars[i]);
        }

        System.out.println(sb);
    }
}