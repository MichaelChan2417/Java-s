package Q191_1_sNumber;

public class Get1Numbers {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0){
            int odd = n & 1;
            if(odd == 1){
                ans++;
            }
            n >>>= 1;
        }
        return ans;
    }
}
