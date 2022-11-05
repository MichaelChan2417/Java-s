package Q239_MaxValSlideWindow;

import java.util.*;

/**
 * TLE
 */
public class MaxValSlideWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));

        int tempMax = nums[0];
        for (int i=0; i<k; i++) {
            pq.offer(nums[i]);
            tempMax = pq.peek();
            if (nums[i] > tempMax) {
                tempMax = nums[i];
            }
        }
        ans[0] = tempMax;

        for (int i=k; i<n; i++) {
            pq.offer(nums[i]);
            pq.remove((Integer) nums[i-k]);
            ans[i-k+1] = pq.peek();
        }

        return ans;
    }
}

/**
 * Improvement on priority queue
 * Time: O(nlogn)
 */
class solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        for (int i=0; i<k; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[n-k+1];
        ans[0] = pq.peek()[0];

        for (int i=k; i<n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] < i-k) {
                pq.poll();
            }
            ans[i-k+1] = pq.peek()[0];
        }

        return ans;
    }
}

/**
 * Singler Queue: if the pushed value larger than any before, pop
 */
class solutionII{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
