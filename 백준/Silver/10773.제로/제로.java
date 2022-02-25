import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int input = scan.nextInt();
            if (input == 0) {
                stack.pop();
            } else {
                stack.add(input);
            }
        }


        int sum = 0;
        for (Integer num : stack) {
            sum += num;
        }

        System.out.println(sum);
    }
}