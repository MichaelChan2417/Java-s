package Q409_LongestPalindrome;

public class LP {
    public int longestPalindrome(String s) {
        int[] counts = new int[52];
        char[] cs = s.toCharArray();

        for(char c : cs){
            counts[geti(c)]++;
        }

        int summ = 0;
        boolean flag = false;
        for(int i=0; i<52; i++){
            if(counts[i] % 2 != 0 && !flag){
                summ++;
                flag = true;
            }
            summ += counts[i]>>1 <<1;
        }

        return summ;
    }

    public int geti(char c){
        if(c>='a' && c<='z'){
            return c-'a';
        }
        if(c>='A' && c<='Z'){
            return c-'A'+26;
        }
        return 0;
    }
}
