# Allocate Books

## Problem Statement

Given an array of integers of size and an integer .
College library has books, the book has number of pages.
You have to allocate books to number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student. Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example, one student cannot be allocated book 1 and book 3, skipping book 2.

Calculate and return that minimum possible number.

## Intuition

Using binary search to narrow down the search range.

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
