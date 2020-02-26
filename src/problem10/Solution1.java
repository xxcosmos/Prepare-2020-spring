package problem10;

/**
 * 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 * 考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
 * 由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值。
 */
public class Solution1 {
    // 递归
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int fibonacciA(int n) {
        int[] array = new int[50];
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];

    }

    public int fibonacciB(int n) {
        int a = 0, b = 1;
        int res = n;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
