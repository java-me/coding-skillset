public class QuickSort {
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// 分区操作，获取基准元素的最终位置
			int pivotIndex = partition(arr, low, high);

			// 递归排序左半部分
			quickSort(arr, low, pivotIndex - 1);
			// 递归排序右半部分
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		// 选择最后一个元素作为基准元素
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				// 交换 arr[i] 和 arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// 将基准元素放到正确的位置
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1; 
		// 这个返回值表明该返回值（即i+1）下标所指向的元素的左边之所有元素都是小于基准元素pivot的。
		// 与此同时，该返回值（即i+1）下标所指向的元素的右边之所有元素都是大于基准元素pivot的。
	}

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		quickSort(arr, 0, arr.length - 1);
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}