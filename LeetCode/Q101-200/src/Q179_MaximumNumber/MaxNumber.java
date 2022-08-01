package Q179_MaximumNumber;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumber {

    public static String largestNumber(int[] nums){
        int n = nums.length;
        Integer[] inums = new Integer[n];
        for(int i=0; i<n; i++){
            inums[i] = nums[i];
        }

        Arrays.sort(inums, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                long sx = 10;
                long sy = 10;
                while(sx <= i1){
                    sx *= 10;
                }
                while(sy <= i2){
                    sy *= 10;
                }

                return (int) ((sx * i2 + i1) - (sy * i1 + i2));
            }
        });

        if(inums[0] == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            sb.append(inums[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3,10,33,34,32,30};

        String s = largestNumber(nums);
    }
}
