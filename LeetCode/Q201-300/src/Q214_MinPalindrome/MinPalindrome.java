package Q214_MinPalindrome;

public class MinPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return s;

        int maxl = 1;
        for(int i=n; i>=0; i--){
            if(isPalin(s.substring(0, i))){
                maxl = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(s.substring(0, maxl));
        for(int i=maxl; i<n; i++){
            char c = s.charAt(i);
            sb.append(c);
            sb.insert(0, c);
        }

        return sb.toString();
    }

    public boolean isPalin(String s){
        int n = s.length();
        int i=0, j=n-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/**
 * Running out of time for s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa...aaaaaaaaaaaaa";
 */
class mySol{
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return s;
        boolean[][] ip = new boolean[n][n];

        for(int i=0; i<n; i++){
            ip[i][i] = true;
            for(int j=0; j<i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j == i-1){
                        ip[j][i] = true;
                    }
                    if(j < i-1){
                        ip[j][i] = ip[j+1][i-1];
                    }
                }
            }
        }

        int maxl = 1;
        for(int i=n; i>0; i--){
            if(ip[0][i-1]){
                maxl = i;
                break;
            }
        }
        // System.out.println(maxl);

        StringBuilder sb = new StringBuilder(s.substring(0, maxl));
        for(int i=maxl; i<n; i++){
            char c = s.charAt(i);
            sb.append(c);
            sb.insert(0, c);
        }

        return sb.toString();
    }
}