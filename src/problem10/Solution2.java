package problem10;

/**
 * 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，
 * 再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，
 * 再覆盖 2*(n-2) 的矩形。而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。
 */
public class Solution2 {
    public int RectCover(int target) {
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
