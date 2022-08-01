public class ada {
    public static long intervalStatistics(int[] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        int index = 0;
        while (arr[index] != 0) {
            index++;
        }

        long res = 0;
        int j = index;
        int count = 0;
        for (int i = index; i < n; i++) {
            if (arr[i] != 0) {
                count -= 1;
                continue;
            }
            while (j < n && count <= k) {
                if (arr[j] == 1) {
                    count += 1;
                }
                j++;
            }
            res += j - i - count;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1,1};
        intervalStatistics(arr , 2);
    }
}
