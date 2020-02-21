package HashTable;

import java.util.Arrays;

class ValidAnagram_sort {

    // sort

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}


class ValidAnagram_hashtable {

    // hash table

    public boolean isAnagram(String s, String t) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            // break early
            if (counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
