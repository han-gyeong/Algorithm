import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> LIS = new ArrayList<>();
        LIS.add(array[0]);

        for (int i = 1; i < n; i++) {
            if (array[i] > LIS.get(LIS.size() - 1)) {
                LIS.add(array[i]);
            } else {
                int index = lowerBound(array[i], LIS);
                LIS.set(index, array[i]);
            }
        }

        System.out.println(LIS.size());
    }

    // 숫자 N 의 Lower bound
    private static int lowerBound(int n, ArrayList<Integer> arrayList) {
        int lt = 0;
        int rt = arrayList.size();

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (arrayList.get(mid) >= n) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return rt;
    }
}