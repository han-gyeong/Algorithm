class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNum = getK(n, k);
        String[] splitNumber = kNum.split("0");

        for (String tmp : splitNumber) {
            if (tmp.length() != 0 && isPrime(Long.parseLong(tmp))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String getK(int n, int k) {
        if (k == 10) {
            return String.valueOf(n);
        }

        StringBuilder sb  = new StringBuilder();
        while (n >= k) {
            int div = n % k;
            n = n / k;
            sb.append(div);
        }

        sb.append(n);
        sb.reverse();
        return sb.toString();
    }
}