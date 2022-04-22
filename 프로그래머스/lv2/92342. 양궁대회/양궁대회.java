import java.util.Arrays;

class Solution {
    public static int[] ryanShoot = {-1};
    public int[] solution(int n, int[] info) {
        track(10, n, new int[11], info);
        return ryanShoot;
    }

    // n -> 몇번째 인덱스, remainArrow -> 남은 화살의 갯수
    public static int answer = 0;
    public static void track(int index, int remainArrow, int[] result, int[] apeachResult) {
        if (index < 0 || remainArrow <= 0) {
            int[] results = calScore(apeachResult, result);
            if ((results[1] - results[0]) > answer) {
                answer = results[1] - results[0];
                ryanShoot = result.clone();
            }
        } else {
            for (int i = remainArrow; i >= 0; i--) {
                result[index] = i;
                track(index - 1, remainArrow - i, result, apeachResult);
            }
        }
    }

    public static int[] calScore(int[] aPeach, int[] ryan) {
        int aPeachScore = 0;
        int ryanScore = 0;
        for (int i = 0; i < aPeach.length; i++) {
            if (aPeach[i] == 0 && ryan[i] == 0) {
                continue;
            }

            if (aPeach[i] >= ryan[i]) {
                aPeachScore += (10 - i);
            } else {
                ryanScore += (10 - i);
            }
        }

        return new int[] {aPeachScore, ryanScore};
    }
}