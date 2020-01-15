package quick.sorting;

import java.util.Arrays;

public class QuickSort {
	
	static int count = 1;

	public static void quicksort(int arr[], int start, int end) {
		if (start < end) {
			int q = partition(arr, start, end); // q에 오는건 pivot 의 위치
			quicksort(arr, start, q - 1);
			quicksort(arr, q + 1, end);
		}
	}

	public static int partition(int arr[], int start, int end) {
		int pivot = arr[end]; // 제일 뒤의 값을 pivot 값으로 잡은 거임.
		int i = start - 1;
		int temp;
		System.out.println("start 값 : " + start + " // end 값: " + end);
		System.out.println(count++ + "번쨰 pivot 값 : " + pivot);
		System.out.println("바뀌기전 Array  :" + Arrays.toString(arr));
		System.out.println("--------------------------------------------");
		
		// 제일 뒤의 값은 pivot이니 비교에서 빼줘야 한다.
		for (int j = start; j < end - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[i + 1];
		arr[i + 1] = pivot;
		arr[end] = temp;
		System.out.println("바뀐 후 Array : " + Arrays.toString(arr));
		System.out.println("------------" +"return pivot index : " +(i+1) +"-------------------------");
		return (i + 1);
	}

	public static void main(String[] args) {
		int[] list = { 58, 8, 28, 3, 18, 6, 33, 20 };
		int size = list.length - 1;
		quicksort(list, 0, size);
	}

}