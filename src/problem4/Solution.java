package problem4;
public class Solution {
//    要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
//
//    该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
//    因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，
//    当前元素的查找区间为左下角的所有元素。
    public boolean Find(int target, int[][] array) {
        int width = array.length;
        int length = array[0].length;
        int i = 0;
        int j = length - 1;
        while (i < width && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}