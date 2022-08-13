package Q264_UglyNumII;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Each time we take out the top pq (x) to be the ith ugly number and insert 2x,3x,5x(and no repetition)
 *
 * Using the minimum heap
 */
public class UglyNumII {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        int[] factors = new int[]{2,3,5};

        Set<Long> seen = new HashSet<>();  // to store the value that have seen;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        seen.add(1L);

        for(int i=0; i<n-1; i++){
            long ugly = pq.poll();
            for(int factor : factors){
                if(!seen.contains(factor * ugly)){
                    seen.add(factor * ugly);
                    pq.offer(factor * ugly);
                }
            }
        }

        int ans = Math.toIntExact(pq.poll());
        return ans;
    }
}

/**
 * Three pointers using dp
 */

class solution{
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}