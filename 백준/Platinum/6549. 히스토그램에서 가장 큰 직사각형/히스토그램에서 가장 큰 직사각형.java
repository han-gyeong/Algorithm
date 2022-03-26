import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int n = scan.nextInt();
            if (n == 0) {
                break;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            System.out.println(solution(arr));
        }
    }

    public static long solution(int[] arr) {
        Stack<Element> elements = new Stack<>();
        elements.add(new Element(0, arr[0]));
        long answer = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < elements.peek().value) {
                int previous_index = arr.length + 1;
                while (!elements.isEmpty() && arr[i] < elements.peek().value) {
                    Element tmp = elements.pop();
                    previous_index = Math.min(previous_index, tmp.from);
                    answer = Math.max(answer, tmp.value + (long) tmp.value * ((i-1) - tmp.from));
                }

                elements.add(new Element(previous_index, arr[i]));
            } else {
                elements.add(new Element(i, arr[i]));
            }
        }

        while (!elements.isEmpty()) {
            Element tmp = elements.pop();
            answer = Math.max(answer, tmp.value + (long) ((arr.length-1) - tmp.from) * tmp.value);
        }

        return answer;
    }

static class Element {
    int from;
    int value;

    public Element(int from, int value) {
        this.from = from;
        this.value = value;
    }
}
}