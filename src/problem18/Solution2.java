package problem18;

public class Solution2 {
    //递归
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val){
                next = next.next;
            }
            return deleteDuplication(next);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }
//        if (pHead == null){
//            return null;
//        }
//        ListNode p = new ListNode(0);
//        ListNode head = p;
//        p.next = pHead;
//        ListNode next = p.next;
//        while (next != null){
//            next = next.next;
//            if (next.val == p.next.val){
//                p.next = p.next.next;
//                p = p.next;
//                next = next.next;
//            }
//        }
//    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
