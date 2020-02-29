package problem41;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution1 {
    int cnt = 0;
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2) -> o2 - o1);
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    public void Insert(Integer num) {
        if (cnt % 2 == 0){
            left.add(num);
            right.add(left.poll());
        } else{
            right.add(num);
            left.add(right.poll());
        }
        cnt++;
    }

    public Double GetMedian() {
        if (cnt %2 == 0){
            return (left.peek() + right.peek()) /2.0;
        } else {
            return right.peek() * 1.0;
        }
    }

}
