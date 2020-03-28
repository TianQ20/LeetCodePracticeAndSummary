package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class Q5_OneWay {
    // 替换 && 长度相等
    // 增加 +1
    // 减少 -1


    public static boolean isOneWay(String A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int countDiff = 0, count = 0;
        for (char c : B.toCharArray()) {
            if (map.containsKey(c)) { // consider replace situation
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    countDiff++;
                    if (countDiff > 1) {
                        return false;
                    }
                }
            } else {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "pale";
        String B = "pkle";
        System.out.println(isOneWay(A, B));
    }
}
