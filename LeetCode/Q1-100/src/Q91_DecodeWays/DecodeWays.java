package Q91_DecodeWays;

public class DecodeWays {

    public static int decodeWays(String s){
        if(s.length() == 0) return 0;

        int[] dp;
        // index-0 check
        char c = s.charAt(0);
        if(c == '0') return 0;
        else{
            if(s.length() == 1){
                return 1;
            }
            dp = new int[s.length()];
            dp[0] = 1;
        }

        // index-1 check
        c = s.charAt(1);
        // second is 0
        if(c == '0'){
            if(s.charAt(0) == '1' || s.charAt(0) == '2'){
                if(s.length() == 2){
                    return 1;
                }
                dp[1] = 1;
            }
            else{
                return 0;
            }
        }
        // second is 7-9
        else if(c>='7' && c<='9'){
            if(s.charAt(0) != '1'){
                dp[1] = 1;
            }
            else{
                return 0;
            }
        }else{

        }

        for(int i=2; i<s.length(); i++){
            c = s.charAt(i);

        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
