package Q28_strStr;

public class strStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if(n == 0) return 0;

        for(int i=0; i<=m-n; i++){
            int j = 0;
            while(j < n && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }

            if(j == n){
                return i-j;
            }

            i -= j;
        }
        return -1;
    }
}
