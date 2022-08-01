package Q274_H_Index;

import java.util.HashMap;
import java.util.Map;

public class H_Index {
    // H-Index is finding a number h with just h numbers of items is not less than h.
    // For example: [3, 0, 6, 1, 5] => h-index is 3 since 3/6/5 (total is 3) is not less than 3

    public static int hIndex(int[] citations){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i : citations){
            int gc = map.getOrDefault(i, 0);
            if(gc == 0){
                map.put(i, gc+1);
            }
            else{
                map.remove(i);
                map.put(i, gc+1);
            }
        }

        int tempmax = 0;
        for(int i : map.keySet()){
            if(map.get(i) >= i && i>tempmax){
                tempmax = i;
            }
        }

        return tempmax;
    }

    public static void main(String[] args) {

    }
}
