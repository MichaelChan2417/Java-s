package Q459_RepeatedSubstring;

public class RepSubstring {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // the next list
        int[] next = new int[n];

        for(int j=0, i=1; i<n; i++){
            while(j>0 && s.charAt(i)!=s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        if(next[n-1] > 0 && (n % (n-next[n-1])) == 0){
            return true;
        }

        return false;
    }
}
