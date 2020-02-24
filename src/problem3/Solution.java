package problem3;

public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

//    要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
//
//    对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
//    本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0;i < length;){
            if(numbers[i] == i){
                i++;
                continue;
            }
            if(numbers[numbers[i]] == numbers[i]){
                duplication[0] = numbers[i];
                return true;
            } else {
                int t = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = t;
            }
        }
        return false;
    }
}