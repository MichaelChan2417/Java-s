package Q45_JumpGameII;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] steps = new int[n];
        for(int i=0; i<n; i++){
            steps[i] = Integer.MAX_VALUE;
        }
        steps[0] = 0;

        for(int i=0; i<n-1; i++){
            int forward = nums[i];
            for(int j=i+1; j<=i+forward; j++){
                if(j<n){
                    if(steps[i] + 1 < steps[j]){
                        steps[j] = steps[i] + 1;
                    }
                }
            }
        }
        return steps[n-1];
    }
}
