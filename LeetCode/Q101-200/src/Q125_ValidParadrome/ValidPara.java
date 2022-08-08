package Q125_ValidParadrome;

public class ValidPara {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n-1;

        String ns = s.toLowerCase();
        char[] cs = ns.toCharArray();

        while(i < j){
            char c1 = cs[i];
            while(i < j && (c1<'a' || c1>'z') && (c1<'0' || c1>'9')){
                c1 = cs[++i];
            }
            if(i >= j) return true;

            char c2 = cs[j];
            while(i < j && (c2<'a' || c2>'z') && (c2<'0' || c2>'9')){
                c2 = cs[--j];
            }
            if(i >= j) return true;

            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
