package Q274_H_Index;

import java.util.HashMap;
import java.util.Map;

public class H_Index {
    // H-Index is finding a number h with just h numbers of items is not less than h.
    // For example: [3, 0, 6, 1, 5] => h-index is 3 since 3/6/5 (total is 3) is not less than 3

    public int hIndex(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
