package Q352_DataStreamAsDisjointIntervals;

import java.util.Comparator;
import java.util.TreeSet;

public class SummaryRanges {
    TreeSet<int[]> holder;

    public SummaryRanges() {
        holder = new TreeSet<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
    }

    public void addNum(int value) {
        int[] addInterval = new int[]{value, value};
        if (holder.contains(addInterval)) return;
        int[] low = holder.lower(addInterval);
        int[] high = holder.higher(addInterval);
        if (high != null && high[0] == value) return;

        // connect two intervals
        if (low != null && low[1] + 1 == value && high != null && high[0] - 1 == value) {
            low[1] = high[1];
            holder.remove(high);
        }
        // merge to left
        else if (low != null && low[1] + 1 >= value) {
            low[1] = Math.max(low[1], value);
        }
        else if (high != null && high[0] - 1 == value) {
            high[0] -= 1;
        }
        else {
            holder.add(addInterval);
        }
    }

    public int[][] getIntervals() {
        int n = holder.size();
        int[][] ans = new int[n][2];

        int index = 0;
        for (int[] interval : holder) {
            ans[index++] = interval;
        }

        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
