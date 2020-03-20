package BinaryTree;

public class BinarySearch {
    public int binarySearch(int arr[], int start, int end, int target)
        {
            while (start < end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) {
                    return mid;
                }

                if (arr[mid] > target) {
                    return binarySearch(arr, start, mid - 1, target);
                } else return binarySearch(arr, mid + 1, end, target);
            }

            return -1;
        }

        // Test
        public static void main(String args[])
        {
            BinarySearch ob = new BinarySearch();
            int arr[] = { 2, 3, 4, 10, 40 };
            int n = arr.length;
            int x = 10;
            int result = ob.binarySearch(arr, 0, n - 1, x);
            if (result == -1)
                System.out.println("Element not present");
            else
                System.out.println("Element found at index " + result);
        }
    }


