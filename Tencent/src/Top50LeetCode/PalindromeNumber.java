package Top50LeetCode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        // because it's considering the case where the input has odd number of digits.
        // For example, x == rev will be enough for an input of 2112,
        // but if your input is 21112, it won't suffice. x==rev/10 will take care of that.
        return (x == rev || x == rev / 10);
    }
}
