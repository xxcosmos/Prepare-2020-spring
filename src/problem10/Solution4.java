package problem10;
// Todo: 动态规划
public class Solution4 {
    public int JumpFloorII(int target) {
        int a = 1;
        int b = 2;

        int sum = target;
        for (int i = 3; i <= target; i++) {
            sum = a + b + 1;
            a = a + b;
            b = sum;

        }
        return sum;
    }

    public int jumpFloor(int target) {
        return (int) Math.pow(2, target - 1);
    }
}
