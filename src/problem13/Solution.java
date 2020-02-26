package problem13;

/**
 * 使用深度优先搜索（Depth First Search，DFS）方法进行求解。
 * 回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态。
 * 而普通的深度优先搜索并不需要使用这些局部状态，虽然还是有可能设置一些全局状态。
 */
public class Solution {
    private int result = 0;
    private int rows = 0;
    private int cols = 0;
    private int threshold = 0;
    private boolean[][] marked = null;
    private int[][] digitSum = null;
    private final static int[][] next = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        this.digitSum = initSumArray(rows, cols);
        this.marked = new boolean[rows][cols];
        dfs(0, 0);
        return this.result;

    }

    private void dfs(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || marked[x][y])
            return;
        marked[x][y] = true;
        if (digitSum[x][y] <= threshold){
            result++;
            for (int[] n:next){
                dfs(x+n[0],y+n[1]);
            }
        }

    }

    private int[][] initSumArray(int rows, int cols) {
        int[] sum = new int[Math.max(rows, cols)];

        for (int i = 0; i < sum.length; i++) {
            int n = i;
            while (n > 0) {
                sum[i] += n % 10;
                n /= 10;
            }
        }

        int[][] digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = sum[i] + sum[j];
            }
        }
        return digitSum;
    }
}
