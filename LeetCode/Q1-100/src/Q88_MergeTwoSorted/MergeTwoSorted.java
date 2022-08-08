package Q88_MergeTwoSorted;

public class MergeTwoSorted {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        for(int i=m+n-1; i>=n; i--){
            nums1[i] = nums1[i-n];
        }
        int index = 0;
        int i = n, j = 0;

        while(i < m+n && j < n){
            if(nums1[i] == nums2[j]){
                nums1[index++] = nums1[i];
                nums1[index++] = nums1[i];
                i++;
                j++;
                continue;
            }
            if(nums1[i] < nums2[j]){
                nums1[index++] = nums1[i];
                i++;
                continue;
            }
            nums1[index++] = nums2[j];
            j++;
        }

        while(j < n){
            nums1[index++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,0,0,0,0,0};
        int[] b = new int[]{1,2,3,5,6};

        merge(a, 1, b, 5);
    }
}
