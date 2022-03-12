import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> numList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            numList.add(scan.nextInt());
        }

        boolean isPossible = true;
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
            } else if (stack.peek() < numList.get(i)) {
                isPossible = false;
            }
        }

        if (!stack.isEmpty() || !isPossible) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}