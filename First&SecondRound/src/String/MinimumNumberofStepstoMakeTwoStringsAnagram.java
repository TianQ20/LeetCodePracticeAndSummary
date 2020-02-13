package String;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int n = s.length(), res = 0;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i++) {
            arr1[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < n; j++) {
            arr2[t.charAt(j) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            res += Math.abs(arr1[i] - arr2[i]);
        }
        return res / 2;
    }
}

// Count the frequency of characters of each string.
// Loop over all characters if the frequency of a character in t is less than the frequency of the same character in s then add the difference between the frequencies to the answer.