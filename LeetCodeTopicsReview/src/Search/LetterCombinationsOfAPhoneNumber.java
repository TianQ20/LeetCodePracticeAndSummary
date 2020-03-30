package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    class Recursion {

        // using hash map and string buffer

        class Solution {
            public List<String> letterCombinations(String digits) {
                if (digits == null || digits.length() == 0) {
                    return new ArrayList<>();
                }

                HashMap<Integer, String> map = new HashMap<>();
                map.put(0, "");
                map.put(1, "");
                map.put(2, "abc");
                map.put(3, "def");
                map.put(4, "ghi");
                map.put(5, "jkl");
                map.put(6, "mno");
                map.put(7, "pqrs");
                map.put(8, "tuv");
                map.put(9, "wxyz");
                List<String> result = new ArrayList<>();
                StringBuffer s = new StringBuffer();
                DFS(digits, s, result, 0, map);
                return result;
            }

            public void DFS(String digits, StringBuffer s, List<String> result, int start, HashMap<Integer, String> map) {
                if (start == digits.length()) {
                    result.add(s.toString());
                } else {
                    String tmp = map.get(digits.charAt(start) - '0');

                    for (int i = 0; i < tmp.length(); i++) {
                        s.append(tmp.charAt(i));
                        DFS(digits, s, result, start + 1, map);
                        s.deleteCharAt(s.length() - 1);
                    }
                }
            }
        }
    }


    class Iteration {
        
        /*

        gave digits = "23"

        i=0 -> result=combine("abc", [""]) ---> [a,b,c];

        i=1 -> result=combine("def", [a,b,c]) ---> [ad,bd,cd, ae,be,ce, af,bf,cf];

        */

        class Solution {
            public List<String> letterCombinations(String digits) {
                if (digits == null || digits.length() == 0) {
                    return new ArrayList<>();
                }

                String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
                List<String> result = new ArrayList<>();
                result.add("");
                for (int i = 0; i < digits.length(); i++) {
                    result = combine(digitletter[digits.charAt(i) - '0'], result);
                }

                return result;
            }

            public List<String> combine(String digit, List<String> list) {
                List<String> result = new ArrayList<>();

                for (int i = 0; i < digit.length(); i++) {
                    for (String x : list) {
                        result.add(x + digit.charAt(i));
                    }
                }
                return result;
            }
        }
    }
}
