package Q1328_BreakAPalindrome;

public class BreakAPalindrome {
    public String breakPalindrome(String palindrome) {
        char[] cs = palindrome.toCharArray();
        int n = cs.length;

        if(n == 1) return "";

        for(int i=0; i<n/2; i++){
            if(cs[i] == 'a'){
                continue;
            }
            cs[i] = 'a';
            return String.valueOf(cs);
        }

        cs[n-1] = 'b';
        return String.valueOf(cs);
    }
}
