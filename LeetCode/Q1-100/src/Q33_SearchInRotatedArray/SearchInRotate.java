package Q33_SearchInRotatedArray;

public class SearchInRotate {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0, r = n;
        while(l < r){
            int mid = (l+r)>>1;
            System.out.println(l + " " + r + " " + mid);
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > nums[l]){
                // the left part is in-order
                if(target>nums[mid] || target<nums[l]){
                    l = mid + 1;
                }
                else{
                    r = mid;
                }
            }
            else{
                // the right part is in-order
                if(target<nums[mid] || target>nums[r-1]){
                    r = mid;
                }
                else{
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
