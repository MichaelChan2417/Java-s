package Q253_MeetingRoomsII;

import java.util.*;

/**
 * Time: O(nlogn);
 * Space: O(n);
 * Using PQ
 */
class solutionI {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // sort pq based on ending time
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        if (intervals.length > 0) {
            pq.offer(intervals[0]);
        }

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = pq.poll();
            // it can be a replacement room
            if (intervals[i][0] >= cur[1]) {
                cur[1] = intervals[i][1];  // change its ending time
            }
            else {
                pq.offer(intervals[i]);
            }
            pq.offer(cur);
        }
        return pq.size();
    }
}

/**
 * Counting planes
 * Times: O(n)
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        // when a meeting start +1 room; when a meeting ends -1 room
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int curMax = 1;
        int curRoom = 0;
        for (int[] room : list) {
            curRoom += room[1];
            if (curRoom > curMax) {
                curMax = curRoom;
            }
        }

        return curMax;
    }
}
