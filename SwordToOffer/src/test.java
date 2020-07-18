public class test {
    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int MOD = (int)1e9 + 7;
        int a = n / 3;
        int b = n % 3;
        if (b == 2) {
            return quickMOD(3, a, MOD) * b;
        } else {
            return quickMOD(3, a - 1, MOD) * (b + 3);
        }
    }

    private static int quickMOD(int a, int b, int MOD) {
        int ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = (ans * b) % MOD;
            }
            b /= 2;
            a = (a * a) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(100));
        System.out.println(quickMOD(3, 2, (int)1e9 + 7));
    }
}

