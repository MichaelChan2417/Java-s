package Q735_AsteroidCollision;

import java.util.*;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stk = new LinkedList<Integer>();

        for(int asteroid : asteroids){
            if(asteroid > 0){
                stk.push(asteroid);
                continue;
            }
            // this is the time when the added in is negative
            if(stk.isEmpty()){
                stk.push(asteroid);
                continue;
            }

            while(true){
                // all defeated
                if(stk.size() == 0){
                    stk.push(asteroid);
                    break;
                }

                int last = stk.pop();
                // both are
                if(last < 0){
                    stk.push(last);
                    stk.push(asteroid);
                    break;
                }
                if(last > 0){
                    if(last + asteroid > 0){
                        stk.push(last);
                        break;
                    }
                    else if(last + asteroid == 0){
                        break;
                    }
                }

            }
        }

        int[] ans = new int[stk.size()];

        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asts = new int[]{5,10,-12,15};

        int[] truu = asteroidCollision(asts);

        System.out.println(Arrays.toString(truu));
    }
}
