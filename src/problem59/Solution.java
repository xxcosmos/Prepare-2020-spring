package problem59;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (size > num.length || size == 0){
            return result;
        }
        int l = 0, r = size - 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for (int i = l; i <= r; i++) {
            queue.add(num[i]);
        }
        result.add(queue.peek());
        for (int i = r+1; i< num.length;i++){
            queue.remove(num[i - r-1]);
            queue.add(num[i]);
            result.add(queue.peek());
        }
        return result;
    }
}
