import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Deque deque = new Deque();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_front")) {
                deque.push_front(Integer.parseInt(input[1]));
                continue;
            } else if (input[0].equals("push_back")) {
                deque.push_back(Integer.parseInt(input[1]));
                continue;
            } else if (input[0].equals("pop_front")) {
                sb.append(deque.pop_front());
            } else if (input[0].equals("pop_back")) {
                sb.append(deque.pop_back());
            } else if (input[0].equals("size")) {
                sb.append(deque.size());
            } else if (input[0].equals("empty")) {
                sb.append(deque.empty());
            } else if (input[0].equals("front")) {
                sb.append(deque.front());
            } else if (input[0].equals("back")) {
                sb.append(deque.back());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

class Deque {
    Node head;
    Node tail;
    int size;

    public Deque() {
        head = tail = null;
        size = 0;
    }

    static class Node {
        int data;
        Node before;
        Node after;

        public Node(int data) {
            this.data = data;
        }
    }

    public void push_front(int x) {
        Node newNode = new Node(x);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            head.before = newNode;
            newNode.after = head;
            head = newNode;
        }
        size++;
    }

    public void push_back(int x) {
        Node newNode = new Node(x);
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.after = newNode;
            newNode.before = tail;
            tail = newNode;
        }
        size++;
    }

    public int pop_front() {
        if (size == 0) {
            return -1;
        } else {
            int data = head.data;
            if (head.after == null) {
                head = tail = null;
            } else {
                head = head.after;
                head.before = null;
            }
            size--;
            return data;
        }
    }

    public int pop_back() {
        if (size == 0) {
            return -1;
        } else {
            int data = tail.data;
            if (tail.before == null) {
                tail = head = null;
            } else {
                tail = tail.before;
                tail.after = null;
            }
            size--;
            return data;
        }
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
        return head.data;
    }

    public int back() {
        if (size == 0) {
            return -1;
        }
        return tail.data;
    }
}