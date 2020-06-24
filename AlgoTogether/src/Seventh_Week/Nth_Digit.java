package Seventh_Week;

public class Nth_Digit {
    class Solution_1 {
        public int findNthDigit(int n) {
            long base = 9, digits = 1;
            while (n - base * digits > 0) {
                n -= base * digits;
                base *= 10;
                digits++;
            }

            long index = n % digits;
            if (index == 0) {
                index = digits; // index is the last bit of related number, which is equal to digits
            }

            long num = 1;
            for (long i = 1; i < digits; i++) {
                num *= 10;
            }
            num += (index == digits) ? (n / digits) - 1 : n / digits; // If index equals to 0, it means the target digit is the last digit of number

            for (long i = index; i < digits; i++) { // get the index-th didit bit
                num /= 10;
            }
            return Math.toIntExact(num % 10);
        }
    }


    class Solution_2 {
        public int findNthDigit(int n) {
            int digits = 1;
            long base = 9;
            int num = 1;

            while (n - base * digits > 0) {
                n -= digits * base;
                digits++;
                base *= 10;
                num *= 10;
            }

            num += (n - 1) / digits;
            String s = String.valueOf(num);
            return s.charAt((n - 1) % digits) - '0';
        }
    }
}
