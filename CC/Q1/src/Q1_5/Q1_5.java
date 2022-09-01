package Q1_5;

/**
 * One time edit: Judge each condition one by one
 * simulate the process
 */
public class Q1_5 {
    // helper func on one bit diff
    public static boolean oneBitDiff(String first, String second){
        boolean diffed = false;
        for(int i=0; i<first.length(); i++){
            if (first.charAt(i) != second.charAt(i)) {
                if(diffed) return false;
                diffed = true;
            }
        }
        return true;
    }

    // helper func judge one bit less; and the first is the shorter one
    public static boolean oneBitLess(String first, String second){
        if (first.length() == 0) return true;
        boolean lessed = false;

        int i=0, j=0;
        while(i < first.length()){
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (lessed) return false;
            lessed = true;
            j++;
        }

        return true;
    }

    public static boolean oneEditAway(String first, String second){
        if (first.length() == second.length()) {
            // judge one bit diff
            return oneBitDiff(first, second);
        }
        else if (first.length() + 1 == second.length()) {
            return oneBitLess(first, second);
        }
        else if (first.length() - 1 == second.length()) {
            return oneBitLess(second, first);
        }
        return false;
    }

    public static void main(String[] args) {
        oneEditAway("adfdsfadsf", "acdfdsfdsf");
    }

}


/**
 * Combine it all
 */
class Q1_5B{
    public static boolean oneEditAway(String first, String second){
        // length error
        if (Math.abs(first.length() - second.length()) > 1) return false;

        String s1 = first.length() <= second.length() ? first : second;
        String s2 = first.length() <= second.length() ? second : first;

        int i1 = 0, i2 = 0;
        boolean isModified = false;

        while (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) != s2.charAt(i2)) {
                if (isModified) return false;
                isModified = true;
                // case when equal length => jump on index1
                if (s1.length() == s2.length()) {
                    i1++;
                }
            }
            else {
                i1++;
            }
            // always move the longer one
            i2++;
        }

        return true;
    }
}


class Tester {

    public static void test(String a, String b, boolean expected) {
        boolean resultA = Q1_5.oneEditAway(a, b);
        boolean resultB = Q1_5B.oneEditAway(a, b);

        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": PASS");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

    }

}

