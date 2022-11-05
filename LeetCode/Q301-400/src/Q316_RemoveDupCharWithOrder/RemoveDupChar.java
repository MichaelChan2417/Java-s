package Q316_RemoveDupCharWithOrder;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDupChar {
    public String removeDuplicateLetters(String s) {
        int[] charCounts = new int[26];
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            charCounts[c-'a']++;
        }

        Deque<Character> stk = new LinkedList<>();
        HashSet<Character> inStk = new HashSet<>();

        for (int i=0; i<s.length(); i++) {
            // each time we deal with char-i
            char c = s.charAt(i);
            charCounts[c-'a']--;
            if (!inStk.contains(c) && (stk.isEmpty() || stk.peek() < c)) {
                stk.push(c);
                inStk.add(c);
            }
            else if (stk.peek() == c || inStk.contains(c)) {
                continue;
            }
            else {
                while (!stk.isEmpty() && stk.peek() > c) {
                    char topChar = stk.peek();
                    if (charCounts[topChar-'a'] == 0) {
                        break;
                    }
                    stk.pop();
                    inStk.remove(topChar);
                }
                stk.push(c);
                inStk.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pollLast());
        }

        return sb.toString();
    }
}
