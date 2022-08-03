package Q56_MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        // sort the array based on the first element from small to large
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff = o1[0] - o2[0];

                if (diff != 0){
                    return diff;
                }
                return o1[1] - o2[1];
            }
        });

        List<int[]> holder = new ArrayList<int[]>();

        for(int i=0; i<n;){
            int l_bound = intervals[i][0];
            int r_bound = intervals[i][1];

            if(i==n-1 || r_bound < intervals[i+1][0]){
                holder.add(intervals[i]);
                i++;
                continue;
            }

            i++;
            while(i<n && r_bound >= intervals[i][0]){
                r_bound = Math.max(r_bound, intervals[i][1]);
                i++;
            }
            holder.add(new int[]{l_bound, r_bound});
        }

        int[][] ans = new int[holder.size()][2];
        int index = 0;
        for(int[] inter : holder){
            ans[index++] = inter;
        }

        return ans;
    }

}
