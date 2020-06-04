package ArraysAndStrings;

public class p4_replace_space_twoPointers {
    public static char[] replaceSpace(char[] str) {
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
        return str;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith";
        char[] arr = str.toCharArray();
        arr = replaceSpace(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
