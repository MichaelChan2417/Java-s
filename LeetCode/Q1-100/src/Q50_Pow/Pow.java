package Q50_Pow;

public class Pow {
    public double myPow(double x, int n){
        if(n == 0 || x == 1) return 1;
        if(n < 0) {
            if(n == Integer.MIN_VALUE){
                return 1.0/myPow(x, -(n+1)) / x;
            }
            return 1.0/myPow(x, -n);
        }

        if(n == 1) return x;

        double tp = myPow(x, n/2);

        if(n % 2 == 1){
            return tp * tp * x;
        }
        return tp * tp;
    }
}
