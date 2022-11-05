package Q456_132Mode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Solution with traverse through point-3. We record the minValue on the left and compare with right ranges
 */
public class Mode132 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        int leftMin = nums[0];

        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }
}

/**
 * Solution with point-1; traverse from right to left.
 */
class SolutionII {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int posVal2 = Integer.MIN_VALUE;
        Deque<Integer> stk = new LinkedList<>();
        stk.push(nums[n-1]);

        for (int i=n-2; i>=0; i--) {
            if (nums[i] < posVal2) {
                return true;
            }
            while (!stk.isEmpty() && nums[i] > stk.peek()) {
                posVal2 = stk.pop();
            }
            if (nums[i] > posVal2) {
                stk.push(nums[i]);
            }
        }

        return false;
    }
}
