package Algorithm.math;

import java.util.Arrays;
//에라토스테네스의 체 알고리즘

public class Eratosthenes {
    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        boolean[] primes = sieve(100);
        for (int i = 2; i <= 100; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
