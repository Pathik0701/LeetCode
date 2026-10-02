package ArraysAndHashing;
import java.util.*;

class ContainsDuplicate_217{
    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                result = true;
            }
        }
        return result;
    }
}