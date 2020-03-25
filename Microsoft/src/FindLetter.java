public class FindLetter {

    // 使用二进制表示大小写，01->lowercase, 10->uppercase
    // 从右向左遍历str，看是否有出现大小写

    public class Solution {
        /**
         * @param str: the str
         * @return: the letter
         */
        public char findLetter(String str) {
            // Write your code here.
            int[] arr = new int[26];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int tmp = 0;
                int index = 0;

                if (c >= 'a') {
                    tmp = 1; // lowercase = uppercase + 32
                    index = c - 'a';
                } else {
                    tmp = 2; // uppercase
                    index = c - 'A';
                }
                arr[index] |= tmp;
            }

            for (int i = 25; i >= 0; i--) {
                if (arr[i] == 3) {
                    return (char)('A' + i);
                }
            }
            return '~';
        }
    }
}
