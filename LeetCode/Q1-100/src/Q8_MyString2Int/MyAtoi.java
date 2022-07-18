package Q8_MyString2Int;
///////////////// False for test cases.... /////////////////////
public class MyAtoi {

    public static int myAtoi(String s){
        int holder = 0;
        boolean negative = false;
        boolean start = false;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            // the negative sign
            if(c == '-'){
                negative = true;
            }
            // the digits
            else if(c>='0' && c <='9'){
                if(start) return 0;
                if(!negative){
                    if( holder > (Integer.MAX_VALUE)/10 ||
                            ((holder == (Integer.MAX_VALUE)/10) && (c-'0')>(Integer.MAX_VALUE%10))){
                        return Integer.MAX_VALUE;
                    }
                    else{
                        holder = holder*10 + (c-'0');
                    }
                }
                else{
                    if( holder > (Integer.MAX_VALUE)/10 ||
                            ((holder == (Integer.MAX_VALUE)/10) && (c-'0')>1+(Integer.MAX_VALUE%10))){
                        return Integer.MIN_VALUE;
                    }
                    else{
                        holder = holder*10 + (c-'0');
                    }
                }

            }
            else if(c == ' '){
            }
            else{
                start = true;
            }
        }
        if(!negative){
            return holder;
        }
        return -1*holder;
    }

    public static void main(String[] args) {

        String s = "54k";

        int i = myAtoi(s);
        System.out.println(i);
    }

}
