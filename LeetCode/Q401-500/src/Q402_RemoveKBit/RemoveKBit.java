package Q402_RemoveKBit;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKBit {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new LinkedList<>();
        int n = num.length();
        if (n <= k) {
            return "0";
        }

        int i = 0;
        while (k > 0 && i < num.length()) {
            char curChar = num.charAt(i);
            if (stk.isEmpty() || stk.peek() <= curChar) {
                stk.push(curChar);
                i++;
            }
            else if (stk.peek() > curChar) {
                stk.pop();
                k--;
            }
        }
        // push in the rest
        while (i < num.length()) {
            stk.push(num.charAt(i++));
        }

        while (k > 0) {
            stk.pop();
            k--;
        }
        // remove front-zeros
        while (!stk.isEmpty() && stk.peekLast() == '0') {
            stk.pollLast();
        }

        if (stk.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pollLast());
        }

        return sb.toString();
    }
}
