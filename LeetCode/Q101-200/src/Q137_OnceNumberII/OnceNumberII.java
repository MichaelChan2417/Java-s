package Q137_OnceNumberII;

public class OnceNumberII {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i=0; i<32; i++) {
            // shift i bits in each round
            int total = 0;
            for (int num : nums) {
                int curBit = (num >> i) & 1;
                total += curBit;
            }
            total = total % 3;

            ans |= (total) << i;
        }

        return ans;
    }
}
