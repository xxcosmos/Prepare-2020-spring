package problem21;

public class Solution {
    public void reOrderArray(int [] array) {
        int oddCnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                oddCnt += 1;
            }
        }
        int oddIndex = 0,evenIndex = oddCnt;
        int[] newArray = array.clone();
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] % 2 == 1){
                array[oddIndex++] = newArray[i];
            } else {
                array[evenIndex++] = newArray[i];
            }
        }

    }
}
