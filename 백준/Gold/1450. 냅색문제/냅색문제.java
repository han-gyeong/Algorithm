import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n, c;
    static int[] items;
    static ArrayList<Integer> aList = new ArrayList<>();
    static ArrayList<Integer> bList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        items = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // A 와 B 에 대해 가능한 조합을 계산하기
        findA(0, 0);
        findB(n / 2, 0);

        // B 배열을 정렬시켜서 이진탐색으로 사용하기
        bList.sort(Comparator.naturalOrder());
        
        int answer = 0;
        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i) > c) {
                continue;
            }

            int count = binarySearch(c - aList.get(i), bList);
            answer += count;
        }

        System.out.println(answer);
    }

    // A에서 나올 수 있는 모든 조합 찾기, 0 ~ N/2 까지
    static void findA(int k, int value) {
        if (value > c) {
            return;
        }

        if (k == n/2) {
            aList.add(value);
            return;
        }

        // 해당 숫자를 포함하지 않거나
        findA(k + 1, value);

        // 해당 숫자를 포함하거나
        findA(k + 1, value + items[k]);
    }

    // B에서 나올 수 있는 모든 경우 찾기, K ~ N 까지
    static void findB(int k, int value) {
        if (value > c) {
            return;
        }

        if (k == n) {
            bList.add(value);
            return;
        }

        // 해당 숫자를 포함하지 않거나
        findB(k + 1, value);

        // 해당 숫자를 포함하거나
        findB(k + 1, value + items[k]);
    }

    // 이진탐색을 이용해서 B 배열에서 해당 숫자의 최대 위치 찾기
    static int binarySearch(int target, ArrayList<Integer> list) {
        int lt = 0;
        int rt = list.size();

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (list.get(mid) > target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return rt;
    }
}