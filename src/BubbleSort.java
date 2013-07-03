import java.util.Arrays;


public class BubbleSort {

	
	public static void main(String[] args) {

		int[] array = {6,5,4,3,2,1};
		array = bubbleSort(array);
		
		System.out.println(Arrays.toString(array));
		
	}
	
	static int[] bubbleSort(int[] array) {
		
		int len = array.length;
		
		for (int i = 1; i < len; i++) {
			int cur = i;
			int j = i - 1;
			
			while (j >= 0 && (array[j] > array[cur])) {
				array = swap(array, j, cur);
				cur = j;
				j--;
			}
		}
		
		return array;
	}
	
	static int[] swap(int[] array, int i1, int i2) {
		
		if (i1 == i2) {
			return array;
		}
		
		int temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
		
		return array;
	}

}
