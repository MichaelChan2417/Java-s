package Q4_MedianOfTwoSortedList;

public class findMedianSortedArrays {
    public static int getKthElement(int[] nums1, int[] nums2, int k){
        int l1 = nums1.length, l2 = nums2.length;
        if(l1 > l2){
            return getKthElement(nums2, nums1, k);
        }
        int i1 = 0, i2 = 0;

        while(true){
            if(i1 == l1){
                return nums2[i2 + k - 1];
            }
            if(i2 == l2){
                return nums1[i1 + k - 1];
            }
            if(k == 1){
                return Math.min(nums1[i1], nums2[i2]);
            }

            int i1_a = Math.min(k/2, l1-i1);
            int i2_a = k - i1_a;
            if(nums1[i1 + i1_a-1] == nums2[i2 + i2_a-1]){
                return nums1[i1 + i1_a-1];
            }
            else if(nums1[i1 + i1_a-1] < nums2[i2 + i2_a-1]){
                i1 += i1_a;
                k -= i1_a;
            }
            else{
                i2 += i2_a;
                k -= i2_a;
            }
        }

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int k = (m+n)/2;
        if((m+n)%2 == 0){
            int t1 = getKthElement(nums1, nums2, k);
            int t2 = getKthElement(nums1, nums2, k+1);
            return (t1+t2)/2.0;
        }
        return getKthElement(nums1, nums2,k+1);
    }


    public static void main(String[] args) {

        int[] n2 = {1,3};
        int[] n1 = {2};

        double ans = findMedianSortedArrays(n1, n2);
        System.out.println(ans);

    }
}
