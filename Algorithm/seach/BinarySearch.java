package Algorithm.seach;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // target not found in the array
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 6, 7, 9};
        int target = 5;
        
        int result = binarySearch(arr, target);
        
        if (result != -1) {
            System.out.println(target + " is at index " + result);
        } else {
            System.out.println(target + " is not in the array");
        }
    }
}
