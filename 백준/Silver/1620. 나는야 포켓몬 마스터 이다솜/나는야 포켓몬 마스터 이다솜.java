import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> numberMap = new HashMap<>();
        HashMap<Integer, String> nameMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numberMap.put(name, i);
            nameMap.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String check = br.readLine();
            if (isNumber(check)) {
                sb.append(nameMap.get(Integer.parseInt(check)));
            } else {
                sb.append(numberMap.get(check));
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}