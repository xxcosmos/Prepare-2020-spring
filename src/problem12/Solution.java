package problem12;

import javax.swing.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABCCED".toCharArray();
        System.out.println(s.hasPath(matrix,3,4,str));
    }

    /**
     * 使用回溯法（backtracking）进行求解，它是一种暴力搜索方法，通过搜索所有可能的结果来求解问题。
     * 回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。
     * 例如下图示例中，从 f 开始，下一步有 4 种搜索可能，如果先搜索 b，需要将 b 标记为已经使用，防止重复使用。
     * 在这一次搜索结束之后，需要将 b 的已经使用状态清除，并搜索 c。
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    // 回溯法
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[][] charMatrix = buildMatrix(matrix, rows, cols);
        rowCnt = rows;
        colCnt = cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (charMatrix[i][j] == (byte)str[0]){
                   // System.out.println("here am i");
                    charMatrix[i][j] = -1;
                    boolean result =  hasPath2(charMatrix,str,i,j,1);
                    if (result){
                        return true;
                    }
                    charMatrix[i][j] = (byte)str[0];

                }
            }
        }
        return false;

    }

    private final static int[][] next = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private int rowCnt = 0, colCnt = 0;

    private boolean hasPath2(int[][] matrix, char[] str, int starta, int startb, int index) {
        if (index == str.length) {
            return true;
        }

        for (int[] indice : next) {
            int a = starta + indice[0];
            int b = startb + indice[1];
            if (isValid(a, b) && matrix[a][b] == (byte)str[index]) {
                matrix[a][b] = -1;
                boolean result =  hasPath2(matrix, str, a, b, index + 1);
                if (result){
                  //  System.out.println("("+a+","+b+")");
                    return true;
                }
                matrix[a][b] = (byte)str[index];
            }
        }
        return false;

    }

    private boolean isValid(int a, int b) {
        return a >= 0 && a < rowCnt && b >= 0 && b < colCnt;
    }

    private int[][] buildMatrix(char[] matrix, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (byte)(matrix[idx++]);
            }
        }
        return result;

    }
}
