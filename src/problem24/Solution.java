package problem24;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode ReverseList(ListNode head) {
        return reverse(null,head);
    }
    public ListNode reverse(ListNode front,ListNode now){
        if (now == null){
            return front;
        }
        ListNode p = now.next;
        now.next = front;
        return reverse(now,p);
    }
}