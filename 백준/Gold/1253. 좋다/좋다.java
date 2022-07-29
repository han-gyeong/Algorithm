import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isGoodNumber(i, arr)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isGoodNumber(int target, int[] arr) {
        int lt = 0;
        int rt = arr.length - 1;

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum < arr[target]) {
                lt++;
            } else if (sum > arr[target]) {
                rt--;
            } else { // 같은 수 일때
                if (lt != target && rt != target) { // 둘 중 어느 수도 target에 포함 안될 경우
                    return true;
                } else if (lt == target) { // lt가 타겟 수 였다면 벗어나고
                    lt++;
                } else if (rt == target) { // rt가 타겟 수 였다면 벗어나기
                    rt--;
                }
            }
        }

        return false;
    }
}