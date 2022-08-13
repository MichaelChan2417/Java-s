package Q128_LongestSeq;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LongestSeq {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxl = 1;
        for(int num : nums){
            /**
             * This is the speed-up part, where
             */
            if(!set.contains(num-1)){
                // make num to be the smallest to add
                int templ = 1;
                while(set.contains(num+1)){
                    templ++;
                    num++;
                }

                if(templ > maxl){
                    maxl = templ;
                }
            }
        }

        return maxl;
    }

}
