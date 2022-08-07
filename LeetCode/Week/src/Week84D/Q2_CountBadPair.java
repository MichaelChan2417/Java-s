package Week84D;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Still running too long
 */
public class Q2_CountBadPair {
    public static long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;

        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int key = nums[i] - i;
            LinkedList<Integer> temp = map.getOrDefault(key, new LinkedList<Integer>());
            temp.add(i);
            map.put(key, temp);
        }

        for(Integer key : map.keySet()){
            // for each key
            LinkedList<Integer> temp = map.get(key);
            int back_size = temp.size();

            for(int i=0; i<back_size; i++){
                int index = temp.get(i);
                ans += n - index + i - back_size;
            }
        }

        return ans;

    }


    public static void main(String[] args) {

        int[] tips = new int[]{1,2,4,4,6};
        long ans = countBadPairs(tips);

        System.out.println(ans);
    }
}


class Solution {
    public long countBadPairs(int[] nums) {
        int n=nums.length;
        long cnt=(long)(1.0d*(1+n-1)*(n-1)/2);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int d=nums[i]-i;
            map.put(d,map.getOrDefault(d,0)+1);
        }
        for(int count:map.values()){
            cnt-=(long)(1.0d*(1+count-1)*(count-1)/2);
        }
        return cnt;
    }
}