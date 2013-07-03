
public class BabbleSort {

	
	public static void main(String[] args) {
		int[] testarray = { 5, 10, 0, 15, -5};
		
		testarray = bsort( testarray);
		display( testarray);
		
	}

	static int[] bsort(int[] array)
	{
		boolean bsorted = false;
		for( int i = 1; i<array.length && !bsorted; i++ )
		{
			bsorted = true;
			for( int j = 0; j< (array.length -i ); j++)
			{
				if(array[j]> array[j+1])
				{
					swap(array, j, j+1);
					bsorted = false;
				}
			}
		}
		return array;
	}
	
	static void display(int[] array)
	{
		for( int i = 0 ; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	static void swap( int[] array, int i1, int i2)
	{
		
			int temp = array[i1];
			array[i1] = array[i2];
			array[i2] = temp;
		
	}
}
