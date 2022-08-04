package Q1545_FindKthBitInN;

public class findKthBit {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");

        for(int i=2; i<=n; i++){
            StringBuilder sp = new StringBuilder(sb);
            sb.append("1");
            sp.reverse();
            for (int j = 0; j < sp.length(); j++) {
                if(sp.charAt(j) == '0'){
                    sp.setCharAt(j, '1');
                }
                else{
                    sp.setCharAt(j, '0');
                }
            }
            sb.append(sp);
        }
        return sb.charAt(k);
    }

    class Solution {
        public char findKthBit(int n, int k) {
            if (k == 1) {
                return '0';
            }
            int mid = 1 << (n - 1);
            if (k == mid) {
                return '1';
            } else if (k < mid) {
                return findKthBit(n - 1, k);
            } else {
                k = mid * 2 - k;
                return invert(findKthBit(n - 1, k));
            }
        }

        public char invert(char bit) {
            return (char) ('0' + '1' - bit);
        }
    }

}
