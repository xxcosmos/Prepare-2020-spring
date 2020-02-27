package problem16;

public class Solution {
    /**
     * 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;

        if (exponent == 1) return base;

        boolean isNeg = false;
        if (exponent < 0) {
            isNeg = true;
            exponent = -exponent;
        }
        int x = 1;
        if (exponent % 2 != 0) x *= base;

        double pow = x * Power(base * base, exponent / 2);
        return isNeg ? 1 / pow : pow;

    }
}
