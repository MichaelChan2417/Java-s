package Q43_MultiplyStrings;

public class MultiplyString {

    public static String multiply(String s1, String s2){
        // the zero cases
        if(s1.equals("0") || s2.equals("0")){
            return "0";
        }

        final int l1 = s1.length(), l2 = s2.length();
        int[] digit = new int[l1+l2];

        // construct the data table
        for(int i=0; i<l1; i++){
            for(int j=0; j<l2; j++){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                digit[l1+l2-i-j-2] += (c1-'0')*(c2-'0');
            }
        }

        // reform the digits
        int carry = 0;
        for(int i=0; i<(l1+l2); i++){
            digit[i] = digit[i] + carry;
            carry = digit[i]/10;
            digit[i] = digit[i]%10;
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<(l1+l2); i++){
            ans.insert(0, digit[i]);
        }
        int i = 0;
        while(ans.charAt(i)=='0'){
            ans.deleteCharAt(i);
        }
        return ans.toString();
    }

    public static void main(String[] args) {

        String a = "123";
        String b = "0000100";

        String c = multiply(a,b);
        System.out.println(c);
    }
}
