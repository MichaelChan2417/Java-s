package Q477_HammingDistance;

public class HammingDistance {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int[] oneCount = new int[32];

        for (int num : nums) {
            for (int i=0; i<32; i++) {
                if (((num >> i) & 1) == 1) {
                    oneCount[i]++;
                }
            }
        }

        int ans = 0;
        for (int i=0; i<32; i++) {
            int ones = oneCount[i];
            int zeros = n - ones;
            ans += ones * zeros;
        }

        return ans;
    }
}
