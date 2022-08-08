package Q55_JumpGame;

public class CanJump {
    // can solve but too slow
    public boolean canJump0(int[] nums) {
        int n = nums.length;
        boolean[] tf = new boolean[n];
        tf[0] = true;

        for(int i=0; i<n; i++){
            if(tf[i]){
                int step_size = nums[i];
                for(int j=i; j<i+step_size; j++){
                    if(j < n){
                        tf[j] = true;
                    }
                }
            }
            return false;
        }
        return tf[n-1];
    }

    // modified
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxl = nums[0]+1;
        for(int i=0; i<nums.length; i++){
            if(i >= maxl){
                return false;
            }
            if(i + nums[i] + 1> maxl){
                maxl = i + nums[i] + 1;
                if(maxl >= n){
                    return true;
                }
            }
        }
        return true;
    }
}
