import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class BabbleSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("this is setup before");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("this is teardown after");
	}

//	@After
	//public void tearDown() throws Exception {
		
	//}
	
	BabbleSort sorter = new BabbleSort();
	int[] sorted = {-1, 1, 10,101,10001};

	@Test
	public void testSorted() {
		assertArrayEquals(sorted, sorter.bsort(new int[] {-1, 1, 10,101,10001}));
		
	}
	
	@Test
	public void testReverse() {
		assertArrayEquals(sorted, sorter.bsort(new int[] {10001, 101, 10, 1, -1}));
		
	}
	@Test
	public void testRandom() {
		assertArrayEquals(sorted, sorter.bsort(new int[] {1, -1, 10001, 10, 101}));
		
	}
	@Test
	public void testFlip() {
		assertArrayEquals(sorted, sorter.bsort(new int[] {1, -1, 101,10,10001}));
		
	}

}
