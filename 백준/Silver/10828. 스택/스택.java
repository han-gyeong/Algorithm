import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                stack.push(Integer.parseInt(input[1]));
                continue;
            } else if (input[0].equals("top")) {
                sb.append(stack.top());
            } else if (input[0].equals("size")) {
                sb.append(stack.size());
            } else if (input[0].equals("pop")) {
                sb.append(stack.pop());
            } else if (input[0].equals("empty")) {
                sb.append(stack.empty());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

class Stack {
    int[] array;
    int size;

    public Stack(int n) {
        size = 0;
        array = new int[n];
    }

    void push(int value) {
        array[size] = value;
        size++;
    }

    int top() {
        if (size == 0) {
            return -1;
        }
        return array[size - 1];
    }

    int size() {
        return size;
    }

    int empty() {
        return size == 0 ? 1 : 0;
    }

    int pop() {
        if (size == 0) {
            return -1;
        }
        int n = array[size - 1];
        size--;
        return n;
    }
}