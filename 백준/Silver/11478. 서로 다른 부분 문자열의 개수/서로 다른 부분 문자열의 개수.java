import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");

        HashSet<String> wordSet = new HashSet<>();
        StringBuilder sb;
        for (int i = 0; i < split.length; i++) {
            sb = new StringBuilder();
            for (int j = i; j < split.length; j++) {
                sb.append(split[j]);
                wordSet.add(sb.toString());
            }
        }

        System.out.println(wordSet.size());
    }
}