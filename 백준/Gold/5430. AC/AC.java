import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            boolean isReverse = false;
            boolean isError = false;
            char[] operations = br.readLine().toCharArray();
            br.readLine();
            LinkedList<Integer> list = strToLinkedList(br.readLine());

            for (char op : operations) {
                if (op == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (list.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        list.pollLast();
                    } else {
                        list.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error").append('\n');
            } else {
                sb.append("[");
                int size = list.size();
                if (isReverse) {
                    for (int m = 0; m < size; m++) {
                        sb.append(list.pollLast());
                        if (m != size - 1) {
                            sb.append(',');
                        }
                    }
                } else {
                    for (int m = 0; m < size; m++) {
                        sb.append(list.pollFirst());
                        if (m != size - 1) {
                            sb.append(',');
                        }
                    }
                }
                sb.append(']').append('\n');
            }
        }
        System.out.println(sb);
    }

    public static LinkedList<Integer> strToLinkedList(String input) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Arrays.stream(input.substring(1, input.length() - 1).split(",")).filter(o -> !o.isEmpty()).forEach(o -> linkedList.add(Integer.parseInt(o)));
        return linkedList;
    }
}