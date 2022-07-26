package Q7_ReverseInteger;

public class ReverseInteger {

    public static int reverse(int x){
        // min_reverse over flow
        if(x == Integer.MIN_VALUE || x == 0){
            return 0;
        }
        // then considering the sign
        boolean sign = x>0;
        x = Math.abs(x);
        int ans = 0;

        while(x > 0){
            int b = x % 10;
            if((ans == Integer.MAX_VALUE/10 && b>Integer.MAX_VALUE%10) || (ans > Integer.MAX_VALUE/10)){
                return 0;
            }
            ans = ans*10 + b;
            x = x / 10;
        }
        if(sign){
            return ans;
        }
        return -1*ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(2147483647));
    }
}
