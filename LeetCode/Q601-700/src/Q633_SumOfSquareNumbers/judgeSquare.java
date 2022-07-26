package Q633_SumOfSquareNumbers;

public class judgeSquare {

    public static boolean judgeSquareSum(int c){
        if(c==0 || c==1){
            return true;
        }
        int l = 0, r = (int) Math.sqrt(Integer.MAX_VALUE);

        while(l <= r){
            if(((long)l *l + (long)r *r) == c){
                 return true;
            }
            else if(((long)l *l + (long)r *r) < c){
                l++;
            }
            else{
                r--;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(8));
    }
}
