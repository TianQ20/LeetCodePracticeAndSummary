package Top50LeetCode;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        char[] s1 = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s1.length; j++) {
            if (s1[j] == ' ') {
                reverse(s1, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s1, i, s1.length - 1);
        return new String(s1);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
