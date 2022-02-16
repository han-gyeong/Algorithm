import java.util.Scanner;

public class Main {
    static int[] left;
    static int[] numbers;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void DFS(int index, int currentValue) {
        if (index == n-1) {
            max = Math.max(currentValue, max);
            min = Math.min(currentValue, min);
        } else {
            for (int i = 0; i < left.length; i++) {
                if (left[i] > 0) {
                    left[i]--;

                    int tmp = 0;
                    switch (i) {
                        case 0:
                            tmp = currentValue + numbers[index + 1];
                            break;
                        case 1:
                            tmp = currentValue - numbers[index + 1];
                            break;
                        case 2:
                            tmp = currentValue * numbers[index + 1];
                            break;
                        case 3:
                            tmp = currentValue / numbers[index + 1];
                            break;
                    }

                    DFS(index + 1, tmp);
                    left[i]++;
                    }
                }
            }
        }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        left = new int[4];
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
             numbers[i] = scan.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            left[i] = scan.nextInt();
        }

        DFS(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }
}