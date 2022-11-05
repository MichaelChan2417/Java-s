package Q252_MeetingRooms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals, determine if a man could attend all meetings
 */
public class MeetingRoom {
    public boolean canAttend(int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i=0; i<meetings.length-1; i++) {
            if (meetings[i][1] > meetings[i+1][0]) {
                return false;
            }
        }

        return true;
    }
}
