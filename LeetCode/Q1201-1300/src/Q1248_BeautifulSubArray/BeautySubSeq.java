package Q1248_BeautifulSubArray;

import java.util.ArrayList;
import java.util.List;

public class BeautySubSeq {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        List<Integer> oddIndex = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(nums[i] % 2 != 0){
                oddIndex.add(i);
            }
        }
        // cannot form beauty
        if(oddIndex.size() < k){
            return 0;
        }

        int start = 0;
        int end;
        int ans = 0;
        for(int i=k-1; i<oddIndex.size(); i++){
            // i denote the right bound index
            int lb = oddIndex.get(i-k+1);
            int rb = oddIndex.get(i);

            if(i == oddIndex.size() - 1){
                end = n-1;
            }
            else{
                end = oddIndex.get(i+1)-1;
            }

            ans += (lb-start+1)*(end-rb+1);

            start = lb+1;
        }

        return ans;
    }
}
