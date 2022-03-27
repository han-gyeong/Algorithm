import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dest;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int destNum = Integer.parseInt(br.readLine());
        dest = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(dest);

        int findNum = Integer.parseInt(br.readLine());
        int[] find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < find.length; i++) {
            sb.append(find(0, dest.length - 1, find[i])).append('\n');
        }

        System.out.println(sb);
    }

    public static int find(int from, int to, int target) {
        int mid = (from + to) / 2;
        if (to < from) {
            return 0;
        }

        if (dest[mid] == target) {
            return 1;
        }


        if (dest[mid] < target) {
            return find(mid + 1, to, target);
        } else {
            return find(from, mid - 1, target);
        }
    }
}