import java.util.Arrays;


public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		
		int num = 15;
		
		System.out.println(Arrays.toString(array));
		
		System.out.println(Integer.toString(binarySearch(array, num, 0, array.length - 1)));
		
		Person[] personArray = new Person[10];
		
		double s = 100.17;
		char ini = 'a';
		
		for (int i = 0; i < 10; i++) {
			
			personArray[i] = new Person(s, ini);
			
			s += 10.50;
			ini += 1;
		}
		
		displayArray(personArray);
		
		System.out.println(Integer.toString(salarySearch(personArray, new Person(100.17, 'b'), 0, 10)));

	}
	
	/**returns index of num in array
	 * if num not found, returns -1
	 */
	static int binarySearch(int[] array, int num, int lo, int hi) {
	
		if (lo == hi) {
			
			if (array[lo] == num) {			
				return lo;
			}
			else {
				
				return -1;
			}
		} 
		
		int mid = (lo  + hi) / 2;
		
		if (array[mid] > num){
			
			return binarySearch(array, num, lo, mid);
		
		} else if (array[mid] < num) {
			
			return binarySearch(array, num, mid + 1, hi);
			
		} else {
			
			return mid;
		}
	}
	
	static int salarySearch(Person[] pArray, Person p, int lo, int hi) {
		
		if (lo == hi) {
			
			if (equalSalaries(pArray[lo], p)) {			
				return lo;
			}
			else {
			
				return -1;
			}
		}
		
		int mid = (lo + hi) /2;
		
		if (equalSalaries(pArray[mid], p)){
					
			return mid;
		
		} else if (greaterSalary(pArray[mid], p)) {
			
			return salarySearch(pArray, p, lo, mid);
			
		} else {
			
			return salarySearch(pArray, p, mid + 1, hi);
			
		}
	}
	
	/**
	 * Each person can be compared by:
	 *double salary
	 *or char initial
	 */
	public static class Person {
		
		public double salary;
		public char initial;
		
		public Person(double s, char i){
			this.salary = s;
			this.initial = i;
		}
		
	}
	
	public static boolean equalSalaries(Person p1, Person p2) {
		
		if (p1.salary == p2.salary) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean greaterSalary(Person p1, Person p2) {
		
		if (p1.salary > p2.salary) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean sameInitials(Person p1, Person p2) {
		
		if (p1.initial == p2.initial) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean greaterInitial(Person p1, Person p2) {
		
		if (p1.initial > p2.initial) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void displayArray(Person[] array){
		
		StringBuilder sb = new StringBuilder("[");
		
		for (int i = 0; i < array.length; i++){
			sb.append("(" + Double.toString(array[i].salary) + ", " + array[i].initial + ")");
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
	}

}
