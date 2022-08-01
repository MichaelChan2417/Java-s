package Q300_LongestIncreasingSubseq;


public class LIS {
}

class myLIS{

    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] holder = new int[n];
        holder[n-1] = 1;

        for(int i=n-2; i>=0; i--){
            int n_large = 1;
            for(int j = i+1; j<n; j++){
                if(nums[j] > nums[i]){
                    n_large = Math.max(n_large, holder[j]+1);
                }
            }
            holder[i] = n_large;
        }

        int temp_max = 1;
        for(int i=0; i<n; i++){
            if(holder[i] > temp_max){
                temp_max = holder[i];
            }
        }
        return temp_max;
    }
}
