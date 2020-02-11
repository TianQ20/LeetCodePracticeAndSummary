package DP;

import java.util.List;


/*
1. 可以直接使用int res = Math.min(triangle.get(i + 1).get(j), triangle(i + 1).get(j + 1)) + triangle.get(i).get(j);
2. 创建一个List<Integer> nextRow, 调用Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
 */
// use array
class Triangle1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}


// use list
class Triangle2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle == null) {
            return 0;
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                List<Integer> nextRow = triangle.get(i + 1);
                int res = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, res); // update minimum sum
            }
        }
        return triangle.get(0).get(0);
    }
}
