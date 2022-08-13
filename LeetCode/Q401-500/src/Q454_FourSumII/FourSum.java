package Q454_FourSumII;

import java.util.HashMap;

public class FourSum {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        HashMap<Integer, Integer> sum1ToReps = new HashMap<>();
        HashMap<Integer, Integer> sum2ToReps = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int key1 = nums1[i] + nums2[j];
                int key2 = nums3[i] + nums4[j];
                // sum1
                int geti = sum1ToReps.getOrDefault(key1, 0);
                sum1ToReps.put(key1, geti+1);
                // sum2
                geti = sum2ToReps.getOrDefault(key2, 0);
                sum2ToReps.put(key2, geti+1);
            }
        }

        int ans = 0;
        for(int key1 : sum1ToReps.keySet()){
            int size1 = sum1ToReps.get(key1);

            if(sum2ToReps.containsKey(-key1)){
                int size2 = sum2ToReps.get(-key1);
                ans += size1 * size2;
            }
        }

        return ans;
    }
}
