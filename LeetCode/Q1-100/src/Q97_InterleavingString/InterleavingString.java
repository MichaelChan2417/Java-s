package Q97_InterleavingString;

public class InterleavingString {
    // Time overflow with the regression
    public static boolean myJudge(String s1, int i1, String s2, int i2, String s3, int i3){
        int n1 = s1.length(), n2 = s2.length();

        // when one reach to its end
        if(i1 == n1){
            return s2.substring(i2).equals(s3.substring(i3));
        }
        if(i2 == n2){
            return s1.substring(i1).equals(s3.substring(i3));
        }

        char c1 = s1.charAt(i1), c2 = s2.charAt(i2), c3 = s3.charAt(i3);
        // if they are the same bit
        if(c1 == c2){
            if(c1 == c3){
                return myJudge(s1, i1+1, s2, i2, s3, i3+1) || myJudge(s1, i1, s2, i2+1, s3, i3+1);
            }
            else{
                return false;
            }
        }
        // not same:
        if(c1 == c3){
            return myJudge(s1, i1+1, s2, i2, s3, i3+1);
        }
        else if(c2 == c3){
            return myJudge(s1, i1, s2, i2+1, s3, i3+1);
        }
        return false;
    }

    public static boolean isInterleave(String s1, String s2, String s3){
        // if they are not the same length, it's false
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }

        return myJudge(s1, 0, s2, 0, s3, 0);
    }

    public static void main(String[] args) {

    }
}

class InterleaveString{
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), o = s3.length();
        if(m+n != o){
            return false;
        }

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        // first row init
        for(int i = 1; i<=m; i++){
            dp[0][i] = (s1.charAt(i-1)==s3.charAt(i-1)) && dp[0][i-1];
        }
        // first column init
        for(int j = 1; j<=n; j++){
            dp[j][0] = (s2.charAt(j-1)==s3.charAt(j-1)) && dp[j-1][0];
        }

        // body fit in
        for(int j=1; j<=n; j++){  // j-th row
            for(int i=1; i<=m; i++){  // i-th column
                dp[j][i] = (dp[j-1][i] && s2.charAt(j-1)==s3.charAt(i+j-1))
                        || (dp[j][i-1] && s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }

        return dp[n][m];
    }
}
