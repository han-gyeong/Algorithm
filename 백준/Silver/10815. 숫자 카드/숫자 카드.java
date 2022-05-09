import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cardInventory = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] cardNumToFind = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> cardMap = new HashMap<>();
        for (int i = 0; i < cardInventory.length; i++) {
            cardMap.put(cardInventory[i], 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cardNumToFind.length; i++) {
            sb.append(cardMap.getOrDefault(cardNumToFind[i], 0)).append(' ');
        }

        System.out.println(sb);
    }
}