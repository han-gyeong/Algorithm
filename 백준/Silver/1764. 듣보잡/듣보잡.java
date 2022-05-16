import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            nameMap.put(name, nameMap.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> overLapName = new ArrayList<>();
        for (String name : nameMap.keySet()) {
            if (nameMap.get(name) == 2) {
                overLapName.add(name);
            }
        }

        overLapName.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(overLapName.size());
        overLapName.forEach(name -> sb.append('\n').append(name));

        System.out.println(sb);
    }
}