import static org.junit.Assert.*;

import org.junit.Test;


public class BubbleSortTest {
	
	BubbleSort sorter = new BubbleSort();
	
	int[] sorted = {1,2,3,4,5,6};

	@Test
	public void testSorted() {
		assertArrayEquals(sorted, sorter.bubbleSort(new int[] {1,2,3,4,5,6}));
	}
	
	@Test
	public void testUnsorted() {
		assertArrayEquals(sorted, sorter.bubbleSort(new int[] {6,5,4,3,2,1}));
	}
	
	@Test
	public void testSwitched() {
		assertArrayEquals(sorted, sorter.bubbleSort(new int[] {2,1,4,3,6,5}));
	}
	
	@Test
	public void testSwap() {
		assertArrayEquals(sorted, sorter.bubbleSort(new int[] {6,2,3,4,5,1}));
	}
	
	@Test
	public void testBigfirst() {
		assertArrayEquals(sorted, sorter.bubbleSort(new int[] {6,1,2,3,4,5}));
	}

}
