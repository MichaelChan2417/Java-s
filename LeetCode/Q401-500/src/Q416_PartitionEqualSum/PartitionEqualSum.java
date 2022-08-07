package Q416_PartitionEqualSum;

public class PartitionEqualSum {
    /**
     * Can the input list be equally partitioned into 2 equal sum
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        // if it's odd, then must cannot
        if(sum % 2 != 0){
            return false;
        }

        return getsum(nums, sum/2);
    }

    public boolean getsum(int[] nums, int target){

    }
}
