package Q11_MaxHoldWater;

public class MaxHoldWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxhold = 0;

        int l = 0, r = n-1;
        while(l < r){
            int h = Math.min(height[l], height[r]);
            int curArea = h * (r-l);
            if(curArea > maxhold){
                maxhold = curArea;
            }

            if(height[l] > height[r]){
                r--;
            }
            else{
                l++;
            }
        }

        return maxhold;
    }
}
