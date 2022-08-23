package Q108_SortedArray2BST.Q739_DailyTemperature;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            int curTemp = temperatures[i];
            while(!stack.isEmpty()){
                int prevIndex = stack.pop();
                // curTemp is smaller
                if(curTemp <= temperatures[prevIndex]){
                    stack.push(prevIndex);
                    break;
                }
                // else the temperature is higher
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return ans;
    }
}
