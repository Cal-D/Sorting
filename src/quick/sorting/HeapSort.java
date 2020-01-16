package quick.sorting;

import java.util.Arrays;

public class HeapSort {

	// node를 루트로 하는 서브트리를 heapify 한다.
	//통상적으로 왼쪽 자식 노드는 곱하기 2 인데, 내가 +1 +2 로 한 이유는, 배열은 0부터 시작이라서 이렇게함.
	static void max_heapify_recursion(int arr[], int i) {
		if ((i * 2 + 1) > arr.length && (i * 2 + 2) > arr.length) {
			return;
		}
		// 자식 노드가 한개만 있을경우
		if ((i * 2 + 1) == arr.length - 1) {
			if (arr[i] >= arr[i * 2 + 1]) {
				return;
			} else {
				int temp = arr[i];
				arr[i] = arr[i * 2 + 1];
				arr[i * 2 + 1] = temp;
				max_heapify_recursion(arr, i * 2 + 1);
			}
		} else {
			// 자식노드가 두개 있을 경우
			int bigger_child = arr[(i * 2) + 1] > arr[(i * 2) + 2] ? (i * 2) + 1 : (i * 2) + 2;
			if (arr[i] >= arr[bigger_child]) {
				return;
			}
			int temp = arr[i];
			arr[i] = arr[bigger_child];
			arr[bigger_child] = temp;
			max_heapify_recursion(arr, bigger_child);
		}
	}

	static void build_max_heap(int arr[]) {
		// 여기 맞나?
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			max_heapify_recursion(arr, i);
		}
	}
	
	static void max_heapify_iterative() {
		
	}

//	static void heapsort(int[] arr) {
//		build_max_heap(arr);
//		int heap_size = arr.length - 1;
//		System.out.println("시작전");
//		for (int i = heap_size; i >= 1;) {
//			System.out.println("시작함");
//			int temp = arr[0];
//			arr[0] = arr[i];
//			arr[i] = temp;
//			i-= 1;
//			max_heapify_recursion(arr, 0);
//		}
//
//	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 7, 6, 5, 34, 3, 2 };
//		heapsort(arr);
		build_max_heap(arr);
		System.out.println(Arrays.toString(arr));
	}
}
