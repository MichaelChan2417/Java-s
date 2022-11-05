package Q393_ValidUTF_8;

public class ValidUTF8 {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        int i = 0;
        while (i < n) {
            int cur = data[i];
            if (isZeroHead(cur)) {
                i++;
                continue;
            }
            int followings = countNum(cur);
            if (followings > 3 || followings == 0) return false;
            i++;
            for (int j=0; j<followings; j++) {
                if (i>=n || !isOneZeroHead(data[i])) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    private boolean isZeroHead(int a) {
        int key = 1 << 7;
        int check = ((a ^ key) >> 7) & 1;

        return check == 1;
    }

    private boolean isOneZeroHead(int a) {
        int key = 1 << 6;
        int check = (a ^ key) >> 6;
        return check == 3;
    }

    private int countNum(int a) {
        int bit = 6;
        int count = 0;
        while (bit > 0) {
            int mask = 1 << bit;
            mask = mask & a;
            mask >>= bit;

            if ((mask & 1) == 0) {
                break;
            }
            count++;
            bit--;
        }

        return count;
    }
}
