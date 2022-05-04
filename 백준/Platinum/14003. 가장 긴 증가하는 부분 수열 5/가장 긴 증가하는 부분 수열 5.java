import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Element> LIS = new ArrayList<>();
        LIS.add(new Element(arr[0], null));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > LIS.get(LIS.size() - 1).value) {
                LIS.add(new Element(arr[i], LIS.get(LIS.size() - 1)));
            } else {
                int lowerBound = lowerBound(arr[i], LIS);
                Element previous = (lowerBound == 0) ? null : LIS.get(lowerBound - 1);
                LIS.set(lowerBound, new Element(arr[i], previous));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(LIS.size()).append('\n');

        Stack<Integer> stack = new Stack<>();
        Element lastElement = LIS.get(LIS.size() - 1);
        while (true) {
            stack.add(lastElement.value);
            lastElement = lastElement.previous;

            if (lastElement == null) {
                break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }

    public static int lowerBound(int target, ArrayList<Element> arrayList) {
        int lt = 0;
        int rt = arrayList.size();

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (target <= arrayList.get(mid).value) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return rt;
    }

    static class Element {
        int value;
        Element previous;

        public Element(int value, Element previous) {
            this.value = value;
            this.previous = previous;
        }
    }
}