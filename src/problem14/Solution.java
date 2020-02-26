package problem14;

public class Solution {
    /**
     * 1. 自顶向下，得到公式
     * 首先定义函数f(n)为把长度为n的绳子剪成若干段后各段长度乘积的最大值。
     * 在剪第一刀时，我们有n-1种选择，也就是说第一段绳子的可能长度分别为1,2,3…..，n-1。因此
     * f(n)=max(f(i)*f(n-i))，其中0<i<n
     * 这是一个自上而下的递归公式。
     *
     * 2. 自底向上，得到base case
     * 由于递归会有大量的不必要的重复计算。一个更好的办法是按照从下而上的顺序计算，也就是说我们先得到f(2),f(3)，再得到f(4),f(5)，直到得到f(n)。
     * eg. 当绳子的长度为2的时候，只能剪成长度为1的两段，所以f(2) = 1，当n = 3时，容易得出f(3) = 2
     * @param target
     * @return
     */
    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[target];
    }

    /**
     * 当n<5时，我们会发现，无论怎么剪切，乘积product <= n，n为4时，product最大为2*2=4；
     * 当n>=5时，可以证明
     * 2(n-2)>n
     * 3(n-3)>n
     * 3(n-3)>=2(n-2)
     * <p>
     * 所以我们应该尽可能地多剪长度为3的绳子段。
     *
     * @param target
     * @return
     */
    private int cutRope2(int target) {
        if (target < 2) return 0;
        if (target == 2) return 1;
        if (target == 3) return 2;
        int times = target / 3;
        if (target - times * 3 == 1) times--;
        int timesOf2 = (target - times * 3) / 2;
        return (int) (Math.pow(3, times) * Math.pow(2, timesOf2));
    }
}
