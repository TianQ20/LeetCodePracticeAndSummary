package Fifth_Week;

import java.util.HashMap;
import java.util.Map;

public class Fraction_to_Recurring_Decimal {
    class Solution {
        public String fractionToDecimal(int num, int den) {
            if (num == 0) return "0";
            StringBuilder sb = new StringBuilder();
            sb.append(((num > 0) ^ (den > 0)) ? "-" : ""); // add negative sign
            Long a = Math.abs((long)num);
            Long b = Math.abs((long)den);

            sb.append(a / b);
            Long remainder = a % b;
            if (remainder == 0) return sb.toString();
            sb.append(".");

            Map<Long, Integer> map = new HashMap<>();
            map.put(remainder, sb.length());

            while (remainder != 0) {
                remainder *= 10;
                sb.append(remainder / b);
                remainder %= b;

                if (map.containsKey(remainder)) { // if the same remainder already exist in hashmap, then it's a infinite loop
                    int index = map.get(remainder);
                    sb.insert(index, "(");
                    sb.append(")");
                    break;
                } else {
                    map.put(remainder, sb.length());
                }
            }
            return sb.toString();
        }
    }
}
