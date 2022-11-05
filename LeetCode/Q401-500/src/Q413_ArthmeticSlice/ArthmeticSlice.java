package Q413_ArthmeticSlice;

import java.util.ArrayList;
import java.util.List;

public class ArthmeticSlice {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int curDiff = nums[1] - nums[0];
        int curNum = 2;
        List<Integer> holder = new ArrayList<>();

        for (int i=2; i<nums.length; i++) {
            int tmpDiff = nums[i] - nums[i-1];

            if (tmpDiff == curDiff) {
                curNum++;
            }
            else {
                if (curNum >= 3) {
                    holder.add(curNum);
                }
                curNum = 2;
                curDiff = tmpDiff;
            }
        }
        if (curNum >= 3) {
            holder.add(curNum);
        }

        int ans = 0;
        for (int i=0; i<holder.size(); i++) {
            int diff = holder.get(i) - 2;
            ans += (1 + diff) * diff / 2;
        }

        return ans;
    }
}
