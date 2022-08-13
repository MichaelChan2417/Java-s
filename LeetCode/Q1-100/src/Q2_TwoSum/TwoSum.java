package Q2_TwoSum;

import ListNode.ListNode;

public class TwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ct = 0;
        int bit_sum = 0;
        ListNode st = new ListNode(-1);
        ListNode hold = st;
        while(l1!=null || l2!=null || ct!=0){
            bit_sum = 0;
            if(l1 != null) {
                bit_sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                bit_sum += l2.val;
                l2 = l2.next;
            }

            bit_sum += ct;

            ct = bit_sum/10;
            bit_sum = bit_sum % 10;

            ListNode node = new ListNode(bit_sum);
            st.next = node;
            st = st.next;
        }

        return hold.next;
    }
}
