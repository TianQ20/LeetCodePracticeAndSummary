package Top50LeetCode;

public class NimGame {
    public boolean canWinNim(int n) {
        // if (n <= 3) return true;
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }
}
