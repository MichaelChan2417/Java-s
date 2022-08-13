package Q1588_OddLengthSum;

import java.util.HashMap;

public class OddLengthSum {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix_sum = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);
        int ans = 0;

        // construct the prefix sum
        int temp = 0;
        for(int i=0; i<n; i++){
            temp += arr[i];
            prefix_sum[i] = temp;
            map.put(i, temp);

            for(int j=0; j<i; j++){
                if( (i-j) % 2 == 0 ){
                    ans += (temp-map.get(j-1));
                }
            }

        }

        ans += prefix_sum[n-1];

        return ans;
    }
}
