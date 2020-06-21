package Seventh_Week;

public class Base_7 {
    class Solution_1 {
        public String convertToBase7(int num) {
            if (num == 0) return "0";
            int r;
            StringBuilder sb = new StringBuilder();
            boolean negative = false;
            if (num < 0) negative = true;

            while (num != 0) {
                r = num % 7;
                sb.append(Math.abs(r));
                num /= 7;
            }

            if (negative) {
                sb.append('-');
            }
            return sb.reverse().toString();
        }
    }


    class Solution {
        public String convertToBase7(int num) {
            if (num < 0) return "-" + convertToBase7(-num);
            if (num < 7) return Integer.toString(num);
            return convertToBase7(num / 7) + convertToBase7(num % 7);
        }
    }
}
