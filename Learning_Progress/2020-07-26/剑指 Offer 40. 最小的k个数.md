# 剑指 Offer 40. 最小的k个数

Sort: time `O(nlogn)`, space `O(n)`.

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i] = arr[i];
            i++;
        }
        return res;
    }
}
```

Min Heap: `O(nlogn)`

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) {
            pq.add(a);
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i++] = pq.poll();
        }
        return res;
    }
}
```

Max Heap: `O(nlogk)`

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> (v2 - v1));
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int num : pq) {
            res[i++] = num;
        }
        return res;
    }
}
```

Count sort: `O(n)`

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0 && idx < k) {
                res[idx++] = i;
            }
            if (idx == k) break;
        }
        return res;
    }
}
```

Quick Select: `O(n)`

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        if (k >= arr.length) return arr;

        partitionArray(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void partitionArray(int[] arr, int lo, int hi, int k) {
        int m = partition(arr, lo, hi);
        if (k == m) {
            return;
        } else if (k < m) {
            partitionArray(arr, lo, m - 1, k);
        } else {
            partitionArray(arr, m + 1, hi, k);
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (v < a[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
```
