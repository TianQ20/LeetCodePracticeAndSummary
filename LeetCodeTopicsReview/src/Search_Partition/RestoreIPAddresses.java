package Search_Partition;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            dfs(s, res, "", 0, 0);
            return res;
        }

        private void dfs(String ip, List<String> res, String restored, int start, int count) {
            if (count > 4) return;
            if (count == 4 && start == ip.length()) res.add(restored);

            for (int i = 1; i < 4; i++) {
                if (start + i > ip.length()) break;
                String tmp = ip.substring(start, start + i);
                // two case: start with "0"; number value >= 256
                if ((tmp.startsWith("0") && tmp.length() > 1) || (i == 3 && Integer.valueOf(tmp) >= 256)) continue;
                dfs(ip, res, restored + tmp + (count == 3 ? "" : "."), start + i, count + 1);
            }
        }
    }
}
