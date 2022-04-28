import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 총 개수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

        arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (st.nextToken().equals("1")) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        String answer = "YES";
        while (st.hasMoreTokens()) {
            if (find(first) != find(Integer.parseInt(st.nextToken()))) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            arr[parentA] = parentB;
        }
    }

    public static int find(int n) {
        if (arr[n] != n) {
            arr[n] = find(arr[n]);
        }

        return arr[n];
    }
}