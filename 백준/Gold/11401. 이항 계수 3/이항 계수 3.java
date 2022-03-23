import java.util.Scanner;

public class Main {
    static final int DIVISON = 1_000_000_007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        long foundAnswer = find(factorial(n - k) * factorial(k), DIVISON - 2); // 곱셈의 역원 (n!(n-k)!)^(m-2)

        long answer = (factorial(n) * foundAnswer) % DIVISON;
        System.out.println(answer);
    }

    static long factorial(int n) {
        long answer = 1;
        while (n >= 1) {
            answer = (answer * n) % DIVISON;
            n--;
        }
        
        return answer;
    }

    static long find(long bottom, long up) {
        if (up == 1) {
            return bottom;
        } else {
            long tmpAnswer = find(bottom, up / 2) % DIVISON;
            if (up % 2 == 1) {
                return ((tmpAnswer * tmpAnswer % DIVISON) * (find(bottom, 1) % DIVISON)) % DIVISON;
            } else {
                return tmpAnswer * tmpAnswer % DIVISON;
            }
        }
    }
}