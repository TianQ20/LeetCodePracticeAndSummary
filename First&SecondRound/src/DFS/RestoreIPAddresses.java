package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        dfs(s, list, 0, "", 0);
        return list;
    }

    private void dfs(String ip, List<String> list, int start, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && start == ip.length()) {
            list.add(restored);
        }

        for (int i = 1; i < 4; i++) {
            if (start + i > ip.length()) break;
            String s = ip.substring(start, start + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) continue;
            dfs(ip, list, start + i, restored + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}


/*
因为这是一道找出所有满足条件的解的题，所以首先考虑Backtracking(DFS).
首先，IP Address每一个section最多三个数，且需要小于256。
这里我们使用count来计算每个section的长度，如果大于4，跳出。
当count等于4且start == ip.length()时，表示上一步刚好完成遍历，此时我们只需要在最后加一个空的""即可。

对section内部进行遍历。如果index > ip.length()，直接break。
此时s(section)使用substring(start, start + i)得到。
如果遇到以"0"开头且长度大于1的 + section内数字大于等于256的，直接跳过此次循环。
对内部的下一次循环，start + i，restored也需要改变，count累加。
 */