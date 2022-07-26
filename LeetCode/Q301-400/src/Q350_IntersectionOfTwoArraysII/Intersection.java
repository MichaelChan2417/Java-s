package Q350_IntersectionOfTwoArraysII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersection {
    /*Given two integer arrays nums1 and nums2, return an array of their intersection.
        Each element in the result must appear as many times as it shows in both arrays
        and you may return the result in any order.
     */

    public static int[] intersect(int[] nums1, int[] nums2) {
        // keep nums1 to be the shorter list
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums1){
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] intersection = new int[nums1.length]; // the maximum length
        int index = 0;
        for(int num : nums2){
            int count = map.getOrDefault(num, 0);
            if(count > 0){
                intersection[index++] = num;
                count--;
                if(count > 0){
                    map.put(num, count);
                }
                else{
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {

    }
}
