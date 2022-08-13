package Q42_RainGet;

public class RainGet {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int temph = 0;
        for(int i=0; i<n; i++){
            if(height[i] > temph){
                temph = height[i];
            }
            left[i] = temph;
        }

        temph = 0;
        for(int i=n-1; i>=0; i--){
            if(height[i] > temph){
                temph = height[i];
            }
            right[i] = temph;
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
