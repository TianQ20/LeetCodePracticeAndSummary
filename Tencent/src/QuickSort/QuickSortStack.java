package QuickSort;

import java.util.Stack;


public class QuickSortStack {
    public void sort(int []arr, int left, int right) {
        int privot, top, last;
        Stack<Integer> s = new Stack<Integer>();
        last=0;
        top=0;
        privot=QuickSort(arr, left, right);
        if(privot>left+1) {
            s.push(left);
            s.push(privot-1);

        }
        if(privot<right-1) {
            s.push(privot+1);
            s.push(right);
        }
        while(!s.empty()) {
            top = s.pop();
            last = s.pop();
            privot = QuickSort(arr, last, top);
            if(privot>last+1) {
                s.push(last);
                s.push(privot-1);
            }
            if(privot<top-1) {
                //System.out.println(top);
                s.push(privot+1);
                s.push(top);
            }
        }
    }


    public int QuickSort(int []arr, int left, int right) {
        int privot = left;
        while(left<right) {
            while((arr[privot]<arr[right])&&left<right) {
                right--;
            }
            int temp = arr[privot];
            arr[privot] = arr[right];
            arr[right] = temp;
            privot = right;

            while((arr[privot]>arr[left])&&left<right) {
                left++;
            }
            temp = arr[privot];
            arr[privot] = arr[left];
            arr[left]  = temp;
            privot  = left;
        }
        return privot;
    }


    public static void main(String[] args) {
        QuickSortStack q = new QuickSortStack();
        int arr[] = {5,3,6,7,2,4,1,32,67,10,45};
        q.sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

