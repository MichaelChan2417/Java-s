package Q829_ConsecutiveSum;

public class ConsecutiveSum {
    public int consecutiveNumbersSum(int n) {
        // the maximum length should be (1+x)*x/2 = n
        if(n == 1) return 1;
        double maxl = Math.sqrt(2*n);

        int ans = 0;
        for(int i=1; i<maxl; i++){
            // the length is i; so the mean value should be n/i
            int mean = n / i;
            // System.out.println("mean:" + mean + " length: " + i);

            if(mean < i/2){
                break;
            }
            // odd length must be integer
            if(i % 2 == 1){
                if(mean * i == n){
                    ans++;
                }
            }
            // even length
            else{
                if(((2*mean + 1) * i/2) == n){
                    ans++;
                }
            }
        }
        return ans;
    }
}
