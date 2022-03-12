import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> numList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(br.readLine()));
        }

        int current = 1;
        for (int i = 0; i < numList.size(); i++) {
            if (stack.isEmpty() || stack.peek() < numList.get(i)) {
                for (;current <= numList.get(i); current++) {
                    stack.add(current);
                    sb.append('+').append('\n');
                }
            }

            if (stack.peek().equals(numList.get(i))) {
                stack.pop();
                sb.append('-').append('\n');
            } else if (!stack.peek().equals(numList.get(i))) {
                break;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}