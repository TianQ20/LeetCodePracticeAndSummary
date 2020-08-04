# 剑指 Offer 58 - I. 翻转单词顺序

Straight forward two pointers solution.
Reverse the whole string first, then reverse each word, delete leading, tailing and multiple spaces.

```java
class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        char[] a = s.toCharArray();
        int n = a.length;
        reverse(a, 0, n - 1);
        reverseWords(a, n);
        return cleanSpaces(a, n);
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' '; // keep only one space
        }
        return new String(a).substring(0, i);
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char tmp = a[i];
            a[i++] = a[j];
            a[j--] = tmp;
        }
    }

    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++;
            while (j < i || j < n && a[j] != ' ') j++;
            reverse(a, i, j - 1);
        }
    }
}
```

Little fancy two pointers solution.

```java
class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // find the first non-space
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--; // skip spaces
            j = i; // set j as the end of this word
        }
        return res.toString().trim();
    }
}
```

Fancy solution.

```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] parts = s.split(" +"); // match at least one space
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            sb.append(parts[i]);
            sb.append(" ");
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
}
```
