package Algorithm.DP;

public class FibonacciDP {
    public static int fibonacci(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n]; // 이미 계산된 값이면 반환
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n, dp));
    }
}

