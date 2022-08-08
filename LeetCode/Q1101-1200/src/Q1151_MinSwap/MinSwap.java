package Q1151_MinSwap;

/**
 * Given a binary array data, return the minimum number of swaps required to group all 1’s present
 * in the array together in any place in the array
 *
 */
public class MinSwap {
    public int minSwaps(int[] data) {
        int n = data.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += data[i];
        }
        // now there are total _sum_ 1s
        // get the first window result
        int tempsum = 0;
        for(int i=0; i<sum; i++){
            tempsum += data[i];
        }
        int maxsum = tempsum;
        // switch window
        int l = 0, r = sum-1;
        while(r < n-1){
            if(data[l] == 1){
                tempsum--;
            }
            if(data[r+1] == 1){
                tempsum++;
            }
            if(tempsum > maxsum){
                maxsum = tempsum;
            }
            l++;
            r++;
        }
        return sum - maxsum;
    }
}
