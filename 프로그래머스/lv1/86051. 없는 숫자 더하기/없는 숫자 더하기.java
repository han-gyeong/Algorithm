import java.util.Arrays;

 class Solution {
    public int solution(int[] numbers) {
        int max = 45;
        int sum = Arrays.stream(numbers).sum();
        return max - sum;
    }
}