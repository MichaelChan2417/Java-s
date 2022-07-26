package Q234_PalindromeLinkedList;

import ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome {

    public static boolean isPalindrome(ListNode head){

        if(head == null){
            return true;
        }

        List<Integer> vals = new ArrayList<Integer>();

        ListNode trv = head;
        while(trv != null){
            vals.add(trv.val);
            trv = trv.next;
        }

        int n = vals.size();
        int i = 0, j = n-1;
        while(i < j){
            if(vals.get(i) != vals.get(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
