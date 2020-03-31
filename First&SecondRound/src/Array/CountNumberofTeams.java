package Array;

public class CountNumberofTeams {

    // less[left] * greater[right] + greater[left] * less[right]
    class Solution1 {
        public int numTeams(int[] rating) {
            int res = 0;
            for (int i = 1; i < rating.length - 1; ++i) {
                int[] less = new int[2];
                int[] greater = new int[2];
                for (int j = 0; j < rating.length; ++j) {
                    if (rating[i] < rating[j]) {
                        ++less[i < j ? 0 : 1];
                    }
                    if (rating[i] > rating[j]) {
                        ++greater[i < j ? 0 : 1];
                    }
                }
                res += less[0] * greater[1] + greater[0] * less[1];
            }
            return res;
        }
    }



    // brute force
    class Solution2 {
        public int numTeams(int[] rating) {
            int count = 0;
            int i, j, k;
            for (k = 2; k < rating.length; k++) {
                for (j = 1; j < k; j++) {
                    for (i = 0; i < j; i++) {
                        if (((rating[i] < rating[j]) && (rating[j] < rating[k])) || ((rating[i] > rating[j]) && (rating[j] > rating[k]))) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }
}
