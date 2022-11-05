package Q275_H_IndexII;

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 1) {
            if (citations[0] >= 1) {
                return 1;
            }
            else {
                return 0;
            }
        }
        int lp = 0, rp = n;

        while (lp < rp) {
            int mp = (lp + rp)/2;
            int numCite = citations[mp];
            int numLarge = n-mp;

            if (numLarge >= numCite) {
                lp = mp + 1;
            }
            else {
                rp = mp;
            }
        }

        if (lp == n) lp--;
        if (citations[lp] > n-lp) {
            lp--;
        }
        if (lp < 0) return citations.length;
        return Math.max(citations[lp], n-lp-1);
    }
}
