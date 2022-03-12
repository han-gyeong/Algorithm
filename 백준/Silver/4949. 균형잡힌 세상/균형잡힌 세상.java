import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            } else {
                sb.append(isBalacned(input)).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static String isBalacned(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '[' || charArray[i] == '(') {
                stack.add(charArray[i]);
            } else if (charArray[i] == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return "no";
                }
            } else if (charArray[i] == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return "no";
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}