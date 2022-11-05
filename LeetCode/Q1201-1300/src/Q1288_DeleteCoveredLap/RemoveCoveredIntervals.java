package Q1288_DeleteCoveredLap;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        int[] preInterval = intervals[0];
        for (int i=1; i<n; i++) {
            if (intervals[i][1] <= preInterval[1]) {
                count++;
            }
            else {
                preInterval = intervals[i];
            }
        }

        return n-count;
    }
}
