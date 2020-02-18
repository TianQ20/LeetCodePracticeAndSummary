package Stack;

public class NextGreaterElementI {

    // brute force
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int j;
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            for (j = 0; j < nums2.length; j++) {
                if (found && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
                if (nums2[j] == nums1[i]) {
                    found = true;
                }
            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }
        return res;
    }
}
