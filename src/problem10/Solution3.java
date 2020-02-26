package problem10;

/**
 * Fibonacci 变形
 */
public class Solution3 {
    public int JumpFloor(int target) {
        // n - 2 n -1
        int a = 1, b =2;
        int res = target;
        for (int i = 3;i<=target;i++){
            res = a + b;
            a = b;
            b = res;
        }
        return res;

    }
}
