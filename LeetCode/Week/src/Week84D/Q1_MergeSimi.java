package Week84D;

import java.util.*;

public class Q1_MergeSimi {

    HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int n1 = items1.length;
        int n2 = items2.length;

        Arrays.sort(items1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(items2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int i=0, j=0;

        while(i < n1 && j < n2){
            int key1 = items1[i][0];
            int key2 = items2[j][0];
            int val1 = items1[i][1];
            int val2 = items2[j][1];

            if(key1 == key2){
                map.put(key1, val1+val2);
                i++;
                j++;
                continue;
            }
            if(key1 < key2){
                map.put(key1, val1);
                i++;
                continue;
            }
            map.put(key2, val2);
            j++;
        }

        while(i < n1){
            int key1 = items1[i][0];
            int val1 = items1[i][1];
            map.put(key1, val1);
            i++;
        }
        while(j < n2){
            int key2 = items2[j][0];
            int val2 = items2[j][1];
            map.put(key2, val2);
            j++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int key : map.keySet()){
            List<Integer> gt = new ArrayList<>();
            gt.add(key);
            gt.add(map.get(key));

            ans.add(gt);
        }
        return ans;
    }
}
