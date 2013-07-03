
public class Choose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Integer.toString(chooser(10,6)));

	}
	
	static int chooser(int n, int k) {
		
		if (k > n || n < 1){
			return 0;
		}
		
		if (k == 0 || k == n) {
			return 1;
		}
		
		return chooser(n - 1, k) + chooser(n - 1, k - 1);
	}

}
