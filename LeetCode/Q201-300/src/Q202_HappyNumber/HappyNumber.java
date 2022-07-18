package Q202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n){
        Set<Integer> s1 = new HashSet<Integer>();

        s1.add(n);
        int hold;

        while(true){
            hold = 0;
            while(n>0){
                hold += Math.pow(n%10, 2);
                n = n/10;
            }
            if(hold == 1){
                return true;
            }
            if(s1.contains(hold)){
                return false;
            }
            s1.add(hold);
            n = hold;
        }

    }

    public static void main(String[] args) {
        boolean k = isHappy(19);
        System.out.println(k);
    }
}
