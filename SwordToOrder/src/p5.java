public class p5 {
    class Solution_1 {
        public String replaceSpace(String str) {
            int len = str.length();
            // count the space number
            int spaceCount = 0;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == ' ') {
                    spaceCount++;
                }
            }
            int trueLength = len + spaceCount * 2; // get the real length after replace space
            StringBuilder sb = new StringBuilder(trueLength);
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != ' ') {
                    sb.append(str.charAt(i));
                } else {
                    sb.append("%20");
                }
            }
            return sb.toString();
        }
    }



    class Solution_2 {
        public String replaceSpace(String s) {
            char[] str = s.toCharArray();
            int len = str.length;
            int spaceCount = 0, i = 0;
            for (i = 0; i < len; i++) {
                if (str[i] == ' ') {
                    spaceCount++;
                }
            }

            int newLength = i + spaceCount * 2;
            int index = newLength - 1;
            // switch to replace space in place
            char[] newStr = str;
            str = new char[newLength];

            for (int j = i - 1; j >= 0; j--) {
                if (newStr[j] == ' ') {
                    str[index] = '0';
                    str[index - 1] = '2';
                    str[index - 2] = '%';
                    index = index - 3;
                } else {
                    str[index--] = newStr[j];
                }
            }
            return charArrayToString(str);
        }

        private String charArrayToString(char[] ch) {
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < ch.length; i++) {
                sb.append(ch[i]);
            }
            return sb.toString();
        }
    }
}
