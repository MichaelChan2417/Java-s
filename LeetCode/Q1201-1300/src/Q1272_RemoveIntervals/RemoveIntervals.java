package Q1272_RemoveIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveIntervals {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[0] > toBeRemoved[1] || i[1] < toBeRemoved[0]) {
                res.add(Arrays.asList(i[0], i[1]));
            }
            else {
                if (i[0] < toBeRemoved[0]) {
                    res.add(Arrays.asList(i[0], toBeRemoved[0]));
                }
                if (i[1] > toBeRemoved[1]) {
                    res.add(Arrays.asList(toBeRemoved[1], i[1]));
                }
            }
        }

        return res;
    }
}
