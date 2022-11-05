package Q457_isClosedLoop;

import java.util.HashSet;

public class isClosedLoop {
    boolean[] visited;

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (visited[i]) {
                continue;
            }
            HashSet<Integer> indexSet = new HashSet<>();
            // starting from this point
            int curIndex = i;

            while (true) {
                indexSet.add(curIndex);
                visited[curIndex] = true;

                int nextIndex = (curIndex + nums[curIndex]);
                while (nextIndex < 0) {
                    nextIndex += n;
                }
                nextIndex %= n;

                if (nums[nextIndex] * nums[curIndex] < 0 || Math.abs(nums[nextIndex]) == n) {
                    break;
                }
                if (indexSet.contains(nextIndex) && indexSet.size() > 1) {
                    return true;
                }
                if (visited[nextIndex]) {
                    break;
                }

                curIndex = nextIndex;
            }

            indexSet.clear();

        }

        return false;
    }
}
