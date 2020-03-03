package Top50LeetCode.Fibonacci;

public class FibonacciNumber {

    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 1;
        return fib(N - 2) + fib(N - 1);
    }
}
