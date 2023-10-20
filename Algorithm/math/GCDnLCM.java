package Algorithm.math;

 // 최대공약수, 최소공배수 알고리즘

public class GCDnLCM {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 15)); // Outputs 3
        System.out.println(lcm(12, 15)); // Outputs 60
    }
}
