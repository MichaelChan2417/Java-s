package Q647_PalindromeSubstr;

public class PalindromeSubstr {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] key = new boolean[n][n];

        int ans = 0;
        for(int i=0; i<n; i++){
            key[i][i] = true;
            ans++;
            for(int j=0; j<i; j++){
                if(j == i-1 && s.charAt(i) == s.charAt(j)){
                    key[j][i] = true;
                    ans++;
                }
                if(j < i-1 && s.charAt(i) == s.charAt(j) && key[j+1][i-1]){
                    key[j][i] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}
