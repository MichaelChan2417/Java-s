package Q150_evalRPN;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalculatorBack {
    public int evalRPN(String[] tokens) {
        HashSet<Character> operas = Stream.of('+','-','*','/').collect(Collectors.toCollection(HashSet::new));

        Deque<Integer> dq = new LinkedList<>();

        for(String token : tokens){
            // operator check
            char c = token.charAt(0);

            if(!operas.contains(c) || token.length() > 1){
                dq.push(Integer.parseInt(token));
                continue;
            }
            int n2 = dq.pop();
            int n1 = dq.pop();

            // System.out.println(c);
            if(c == '+'){
                dq.push(n1 + n2);
            }

            if(c == '-'){
                dq.push(n1 - n2);
            }

            if(c == '*'){
                dq.push(n1 * n2);
            }

            if(c == '/'){
                dq.push(n1 / n2);
            }
        }

        return dq.pop();
    }
}
