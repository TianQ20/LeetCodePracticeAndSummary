# Allocate Books

## Problem Statement

Given an array of integers A of size N and an integer B.

College library has N bags,the ith book has A[i] number of pages.

You have to allocate books to B number of students so that maximum number of pages alloted to a student is minimum.

## Intuition

Using binary search to narrow down the search range.
**// add image illustration**

```java
public class Allocate_Books {

    public static int allocate_books(int[] A, int n, int B) {
        if (n < B) return -1;

        int sum = 0;
        for (int i : A) {
            sum += i;
        }

        int start = 0, end = sum, res = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(A, n, B, mid)) {
                res = Math.min(res, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private static boolean isPossible(int[] A, int n, int B, int curMin) {
        int students = 1, curSum = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > curMin) {
                return false;
            }

            if (A[i] + curSum > curMin) {
                curSum = A[i];
                students++;
                if (students > B) {
                    return false;
                }
            }
            curSum += A[i];
        }
        return true;
    }

    // driver function
    public static void main(String[] args) {
        int[] A = new int[] {12, 34, 67, 90};
        int n = A.length;
        int B = 2;
        int res = allocate_books(A, n, B);
        System.out.println(res);

        int[] A2 = new int[] {5, 17, 100, 11}; // why not increasing order also works?
        int m = A2.length;
        int C = 4;
        System.out.println(allocate_books(A2, m, C));
    }
}
```
