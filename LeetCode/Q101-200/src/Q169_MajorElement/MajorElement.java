package Q169_MajorElement;

public class MajorElement {
    public int majorityElement(int[] nums) {
        int majorNum = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            if(count == 0){
                majorNum = num;
                count++;
                continue;
            }
            if(num == majorNum){
                count++;
                continue;
            }
            count--;
        }
        return majorNum;
    }
}
