package Q136_SingleNumber;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 */
public class SingleAppearNum {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i : nums){
            ans ^= i;
        }

        return ans;
    }
}
