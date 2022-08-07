package Q947_MostStonesRemove;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveStones {

    public int removeStones(int[][] stones) {
        int n = stones.length;  // get the stone numbers
        List<List<Integer>> map = new ArrayList<List<Integer>>();

        for(int i=0; i<n; i++){
            map.add(new ArrayList<Integer>());
        }
        // the map construction
        for(int i=0; i<n-1; i++){
            int st1_x = stones[i][0];
            int st1_y = stones[i][1];

            for(int j=i+1; j<n; j++){
                int st2_x = stones[j][0];
                int st2_y = stones[j][1];

                if(st1_x == st2_x || st1_y == st2_y){
                    List<Integer> list1 = map.get(i);
                    List<Integer> list2 = map.get(j);

                    list1.add(j);
                    list2.add(i);
                }
            }
        }

        // the map traverse
        Queue<Integer> q = new LinkedList<Integer>();
        int ans = 0;

        // add in the q
        int geti = getIndex(map, n);
        if(geti < 0){
            return ans;
        }
        q.offer(geti);

        while (!q.isEmpty()){
            int index = q.poll();
            // this stone can be removed
            ans++;

            // decrease its association
            List<Integer> ret_list = map.get(index);

            for(int i=0; i<ret_list.size(); i++){
                // get its neighbor's id
                int neighbor_i = ret_list.get(i);

                List<Integer> neighbor = map.get(neighbor_i);
                int j = 0;
                for(; j<neighbor.size(); j++){
                    if(neighbor.get(j) == i){
                        break;
                    }
                }
                neighbor.remove(j);
            }
            ret_list.clear();

            // find in q
            int next_i = getIndex(map, n);
            if(next_i > 0){
                q.offer(next_i);
            }
        }

        return ans;
    }

    public int getIndex(List<List<Integer>> map, int n){
        int choice = -1;
        int tempmax = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            List<Integer> gt = map.get(i);
            if(gt.size() > 0 && gt.size()<tempmax){
                tempmax = gt.size();
                choice = i;
            }
        }

        return choice;
    }
}

[[1, 5], [0, 2, 5], [1, 3], [2, 4], [3], [0, 1]]
        [[1, 5], [0, 2, 5], [1, 3], [2], [], [0, 1]]
        [[1, 5], [0, 2, 5], [1, 3], [2], [], [0, 1]]
        [[1, 5], [0, 2, 5], [1], [], [], [0, 1]]
        [[1, 5], [0, 2, 5], [1], [], [], [0, 1]]
        [[1, 5], [0, 5], [], [], [], [0, 1]]

