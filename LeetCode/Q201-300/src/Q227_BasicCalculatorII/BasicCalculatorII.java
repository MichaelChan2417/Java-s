package Q227_BasicCalculatorII;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculatorII {
    public static int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' ') {
                continue;
            }
            sb.append(c);
        }
        s = sb.toString();

        Deque<Character> ope = new LinkedList<Character>();
        Deque<Integer> nums = new LinkedList<Integer>();
        // final use
        ope.push('+');
        nums.push(0);

        for(int i=0; i<s.length(); ){
            char c = s.charAt(i);
            // ope-detect
            if(c == '+' || c == '-'){
                ope.push(c);
                nums.push(0);
                i++;
            }
            else if(c == '*' || c == '/'){
                nums.push(0);
                i++;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    int temp_num = nums.pop();
                    temp_num = temp_num*10 + (s.charAt(i)-'0');
                    nums.push(temp_num);
                    i++;
                }
                int num2 = nums.pop();
                int num1 = nums.pop();

                if(c == '*'){
                    nums.push(num1 * num2);
                }
                else{
                    nums.push(num1/num2);
                }
            }
            else if(c>='0' && c<='9'){
                int temp_num = nums.pop();
                temp_num = temp_num*10 + (c-'0');
                nums.push(temp_num);
                i++;
            }
        }

        int ans = 0;
        while(!ope.isEmpty()){
            char op = ope.pop();
            int num = nums.pop();

            if(op == '+'){
                ans += num;
            }
            else{
                ans -= num;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        calculate("3*5");
    }
}
