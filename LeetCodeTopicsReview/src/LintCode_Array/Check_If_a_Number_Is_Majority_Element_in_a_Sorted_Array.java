package LintCode_Array;

public class Check_If_a_Number_Is_Majority_Element_in_a_Sorted_Array {
    class Solution {
        public boolean isMajorityElement(int[] nums, int target) {
            return nums[(nums.length + 1) / 2 - 1] == target ? true : false;
        }
    }
}
