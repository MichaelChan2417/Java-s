package Q611_ValidTriangleNumber;

import java.util.Arrays;

public class ValidTriangles {
//Given an integer array nums, return the number of triplets chosen from the array that can make triangles
// if we take them as side lengths of a triangle.
//
    public static int triangleNumber(int[] nums){
        int n = nums.length;
        if(n < 3) return 0;

        int i, j, k;
        int total = 0;

        Arrays.sort(nums);
        for(i = 0; i<n-2; i++){
            j = i+1;
            k = j+1;

            while(k < n){
                if(nums[i] + nums[j] > nums[k]){
                    k++;
                }
                else{
                    j++;
                    total += k-j;
                    if(j == k){
                        k++;
                    }
                }
            }
            total += (k-j)*(k-j-1)/2;
        }

        return total;
    }

    public static void main(String[] args) {

        int[] a = new int[]{2, 3, 5, 6};

        System.out.println(triangleNumber(a));

    }

}
