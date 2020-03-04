package QuickSort;


public class QuickSort {
    public void sort(int[] arr, int left, int right) {
        int pivot;
        if(left < right) {
            pivot = QuickSort(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
    }


    public int QuickSort(int []arr, int left, int right) {
        int pivot = left; //快排支点。一般是最左边的元素
        while(left < right) {

            while((arr[pivot] < arr[right]) && left < right) {
                right--;
            }
            int temp = arr[right];
            arr[right] = arr[pivot];
            arr[pivot] = temp;
            pivot = right;

            while((arr[left] < arr[pivot]) && left < right) {
                left++;
            }
            temp = arr[left];
            arr[left] = arr[pivot];
            arr[pivot] = temp;
            pivot = left;
        }

        return pivot;
    }


    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int arr[] = {5,3,6,7,2,4,1,32,67,10,45};
        q.sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
