package Q1283_FindSmallestDivisor;

public class SmallestDivisor {

    public int smallestDivisor(int[] nums, int threshold) {
        // Get the max num in the list
        int tempmax = nums[0];
        for(int i : nums){
            if(i > tempmax){
                tempmax = i;
            }
        }

        int l = 1, r = tempmax;
        while(l < r){
            int mid = (l + r)>>1;
            int loc_sum = 0;

            for(int i : nums){
                loc_sum += i/mid;
                if(i % mid != 0){
                    loc_sum++;
                }
                // loc_sum += ((nums[i] + mid - 1) / mid);  //Tricky way to get the upper divide
            }

            if(loc_sum > threshold){
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}
