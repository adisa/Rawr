import static org.junit.Assert.*;

import org.junit.Test;


public class BinarySearchTest {

	BinarySearch searcher = new BinarySearch();
	
	int[] array = {1,2,3,4,5,6,7,8,9,10};
	
	@Test
	public void testBig() {
		assertEquals(-1, searcher.binarySearch(array, 15, 0, 9));
	}
	
	@Test
	public void testSmall() {
		assertEquals(-1, searcher.binarySearch(array, -5, 0, 9));
	}
	
	@Test
	public void testLower() {
		assertEquals(0, searcher.binarySearch(array, 1, 0, 9));
	}
	
	@Test
	public void testHigher() {
		assertEquals(9, searcher.binarySearch(array, 10, 0, 9));
	}
	
	@Test
	public void testMid() {
		assertEquals(4, searcher.binarySearch(array, 5, 0, 9));
	}

}
