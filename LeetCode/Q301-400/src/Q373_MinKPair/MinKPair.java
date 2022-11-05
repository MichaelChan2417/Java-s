package Q373_MinKPair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinKPair {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0; i<Math.min(k, m); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] minPair = pq.poll();
            List<Integer> curPair = new ArrayList<>();
            curPair.add(nums1[minPair[0]]);
            curPair.add(nums2[minPair[1]]);

            ans.add(curPair);

            if (minPair[1] + 1 < n) {
                pq.offer(new int[]{minPair[0], minPair[1]+1});
            }
            k--;
        }

        return ans;
    }
}
