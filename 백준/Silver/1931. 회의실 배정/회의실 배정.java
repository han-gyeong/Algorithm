import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][2];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= endTime) {
                answer++;
                endTime = arr[i][1];
            }
        }

        System.out.println(answer);

    }
}