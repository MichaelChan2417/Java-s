package Q1427_StringLeftRight;

public class StringLeftRight {
    public String stringShift(String s, int[][] shift) {
        int sum = 0;
        for(int[] pair : shift){
            if(pair[0] == 0){
                sum += pair[1];
                continue;
            }
            sum -= pair[1];
        }

        if(sum == 0){
            return s;
        }
        int n = s.length();
        if(sum > 0){
            sum = sum % n;
            String s1 = s.substring(0, sum);
            String s2 = s.substring(sum, n);
            return s2+s1;
        }
        sum = (-sum) % n;
        String s1 = s.substring(0, n-sum);
        String s2 = s.substring(n-sum, n);
        return s2 + s1;
    }
}
