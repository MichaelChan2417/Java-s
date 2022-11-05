package Q435_NoOverlapping;

import java.util.Arrays;
import java.util.Comparator;

public class NoOverLapping {
    // once there is an overlapping, delete the late-ending one
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] curPair = intervals[0];
        for (int[] i : intervals) {
            if (i[0] >= curPair[1]) {
                curPair = i;
            }
            else {
                if (i[1] < curPair[1]) {
                    curPair = i;
                }
                count++;
            }
        }

        return count - 1; // we always make an count on the first entry
    }
}
