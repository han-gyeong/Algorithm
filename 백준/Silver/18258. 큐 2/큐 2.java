import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                queue.push(Integer.parseInt(input[1]));
                continue;
            } else if (input[0].equals("front")) {
                sb.append(queue.front());
            } else if (input[0].equals("back")) {
                sb.append(queue.back());
            } else if (input[0].equals("size")) {
                sb.append(queue.size);
            } else if (input[0].equals("pop")) {
                sb.append(queue.pop());
            } else if (input[0].equals("empty")) {
                sb.append(queue.empty());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

    class Queue {
        Node top;
        Node last;
        int size;

        public Queue() {
            top = null;
            last = null;
            size = 0;
        }

        static class Node {
            public Node(int data) {
                this.data = data;
            }

            int data;
            Node before;
            Node after;
        }

        public void push(int n) {
            if (size == 0) {
                top = last = new Node(n);
            } else {
                Node newNode = new Node(n);
                last.after = newNode;
                last = newNode;
            }
            size++;
        }

        public int pop() {
            if (size == 0) {
                return -1;
            }
            int tmp = top.data;

            if (top.after != null) {
                top = top.after;
                top.before = null;
            } else {
                top = null;
            }
            size--;
            return tmp;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            if (size == 0) {
                return -1;
            }
            return top.data;
        }

        public int back() {
            if (size == 0) {
                return -1;
            }
            return last.data;
        }
    }