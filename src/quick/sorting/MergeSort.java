package quick.sorting;

import java.util.Arrays;

public class MergeSort {

	static int[] sorted = new int[8]; // 돌아가는 형태를 보기 위해 일단 작게 해서 보자.
	static int count = 1;

	public static void merge(int arr[], int start, int middle, int end) {
		System.out.println("start 값 : " + start);
		System.out.println("end 값 : " + end);
		System.out.println("middle 값 : " + middle);
		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (arr[i] <= arr[j]) {
				sorted[k++] = arr[i++];
			} else {
				sorted[k++] = arr[j++];
			}
		}
		if (i > middle) {
			while (j <= end) {
				sorted[k++] = arr[j++];
			}
		} else {
			while (i <= middle) {
				sorted[k++] = arr[i++];
			}
		}
		
		for(int t = start;t <= end; t++) {
			arr[t] = sorted[t];
		}
		System.out.println((count++) + "번째 merge sort 후 : " + Arrays.toString(arr));

	}

	public static void mergeSort(int a[], int start, int end) {
		int middle;
		if(start < end) {
			middle = (start + end) /2 ;
			mergeSort(a, start, middle);
			mergeSort(a, middle + 1, end);
			merge(a, start, middle, end);
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] list = {58,8,28,3,18,6,33,20};
		int size = list.length - 1;
		mergeSort(list, 0, size);
		
	}
	
}
