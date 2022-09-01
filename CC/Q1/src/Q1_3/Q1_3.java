package Q1_3;

/**
 * URLlize: Replace all space with %20, the given String hold true length
 */
public class Q1_3 {
    public static void replaceSpaces(char[] str, int trueLength){
        int n = str.length;
        char[] ans = new char[n];
        int i = 0, index = 0;

        while (i < trueLength) {
            // if the cur char is not \0
            if (str[i] != ' ') {
                ans[index++] = str[i++];
                continue;
            }
            ans[index++] = '%';
            ans[index++] = '2';
            ans[index++] = '0';
            i++;
        }

        String ansStr = String.valueOf(ans);
        System.out.println(ansStr);
    }

    // find the true length
    public static int findLast(char[] arr){
        int n = arr.length;
        int i=n-1;
        for (; i>=0; i--) {
            if (arr[i] != ' ') {
                break;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        String str = "Mr John Sm ith      ";
        char[] arr = str.toCharArray();
        int trueLength = findLast(arr);

        replaceSpaces(arr, trueLength);

    }
}
