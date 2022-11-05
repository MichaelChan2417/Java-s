package Q38_OutList;

public class OutList {
    StringBuilder osb = new StringBuilder();
    StringBuilder sb = new StringBuilder();

    public String countAndSay(int n) {
        osb = new StringBuilder("1");

        for (int i=0; i<n-1; i++) {
            int curNum = 0;
            char curChar = osb.charAt(0);

            for (int j=0; j<osb.length(); j++) {
                if (curChar == osb.charAt(j)) {
                    curNum++;
                }
                else {
                    sb.append(curNum);
                    sb.append(curChar);
                    curChar = osb.charAt(j);
                    curNum = 1;
                }
            }
            sb.append(curNum);
            sb.append(curChar);

            osb = new StringBuilder(sb);
            sb.delete(0, sb.length());
        }

        return osb.toString();
    }
}
