package Q20_ValidParentheses;

import java.util.Deque;
import java.util.LinkedList;

public class ValidPar {
    public boolean isValid(String s) {
        Deque<Character> q = new LinkedList<Character>();

        for(char c: s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                q.push(c);
            }
            else{
                if(q.size() == 0){
                    return false;
                }
                char g = q.peek();
                if(c==')' && g!='('){
                    return false;
                }
                else if(c==']' && g!='['){
                    return false;
                }
                else if(c=='}' && g!='{'){
                    return false;
                }
                q.pop();
            }
        }

        return q.isEmpty();
    }
}
