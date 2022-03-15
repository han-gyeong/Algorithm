import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Print {
        int count; // 몇번째로 완료되는지
        int index; // 몇번째 입력값인지
        int priority; // 우선순위

        public Print(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Print> waitingList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int[] optionArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] priorityArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < priorityArr.length; j++) {
                waitingList.add(new Print(j, priorityArr[j]));
            }

            int count = 1;
            while (!waitingList.isEmpty()) {
                Print thisTurn = waitingList.poll();
                int size = waitingList.size();
                boolean isOkay = true;

                for (int k = 0; k < size; k++) {
                    Print compare = waitingList.poll();
                    if (compare.priority > thisTurn.priority) {
                        isOkay = false;
                    }
                    waitingList.add(compare);
                }

                if (isOkay) {
                    thisTurn.count = count++;
                    if (thisTurn.index == optionArr[1]) {
                        System.out.println(thisTurn.count);
                        break;
                    }
                } else {
                    waitingList.add(thisTurn);
                }
            }
            waitingList.clear();
        }
    }
}