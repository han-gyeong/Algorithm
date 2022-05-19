import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int i = 0; i < aSize; i++) {
            aMap.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < bSize; i++) {
            bMap.put(Integer.parseInt(st.nextToken()), 1);
        }

        int answer = 0;
        Set<Integer> aKeys = aMap.keySet();
        for (Integer aKey : aKeys) {
            if (bMap.get(aKey) == null) {
                answer++;
            }
        }

        Set<Integer> bKeys = bMap.keySet();
        for (Integer bKey : bKeys) {
            if (aMap.get(bKey) == null) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}