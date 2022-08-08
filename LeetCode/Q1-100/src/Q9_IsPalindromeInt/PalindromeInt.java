package Q9_IsPalindromeInt;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeInt {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        Deque<Integer> items = new LinkedList<>();

        while(x > 0){
            int b = x % 10;
            items.offerLast(b);
            x = x/10;
        }

        while(items.size() > 1){
            int head = items.pollFirst();
            int tail = items.pollLast();
            if(head != tail){
                return false;
            }
        }

        return true;
    }
}
