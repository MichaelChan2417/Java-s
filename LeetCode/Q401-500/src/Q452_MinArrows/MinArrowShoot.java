package Q452_MinArrows;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowShoot {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long comp = (long) o1[0] - o2[0];
                if(comp > 0){
                    return 1;
                }
                if(comp < 0){
                    return -1;
                }
                return 0;
            }
        });

        int i = 0;
        int arrows = 0;

        while(i<n){
            int[] most_left = points[i];
            int right_bound = most_left[1];

            // if it is the final balloon
            if(i == n-1){
                arrows++;
                break;
            }
            // compare the next
            while(i < n && points[i][0] <= right_bound){
                right_bound = Math.min(right_bound, points[i][1]);
                i++;
            }
            arrows++;
        }
        return arrows;
    }
}
