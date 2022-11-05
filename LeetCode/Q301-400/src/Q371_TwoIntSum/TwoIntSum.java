package Q371_TwoIntSum;

public class TwoIntSum {
    public int getSum(int a, int b) {
        int carry = 0;
        int ans = 0;

        for (int i=0; i<32; i++) {
            int bita = a & 1;
            int bitb = b & 1;

            int bitans = bita ^ bitb ^ carry;
            carry = (bita & bitb) | (bita & carry) | (bitb & carry);
            ans |= bitans<<i;

            a >>= 1;
            b >>= 1;
        }

        return ans;
    }
}
