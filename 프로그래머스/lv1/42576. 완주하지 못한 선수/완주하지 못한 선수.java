import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> winners = new HashMap<>();

        for (String name : completion) {
            winners.put(name, winners.getOrDefault(name, 0) + 1);
        }

        for (String name : participant) {
            if (winners.get(name) == null || winners.get(name) == 0) {
                return name;
            }

            winners.put(name, winners.get(name) - 1);
        }

        return "";
    }
}