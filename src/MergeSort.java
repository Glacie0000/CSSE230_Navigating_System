

public class MergeSort {
	
	public static int count = 0;
	
	public static void main(String args[]) {
		Integer a[] = new Integer[16];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer((int)(Math.random()*16));
			//System.out.print(a[i] + " ");
		}
		//System.out.println();		

		sort(a, 0, a.length - 1);
		System.out.println(count);

		for (int i = 0; i < a.length; i++) {
			//System.out.print(a[i] + " ");
		}
		//System.out.println();
	}
	
	public static void sort(Comparable a[], int lower, int upper) {
		if (lower < upper) {
			int middle = (lower + upper) / 2;
			sort(a, lower, middle);
			sort(a, middle + 1, upper);
			putTogether(a, lower, upper);
		}
	}
	
	
	
	
	
	
	public static void putTogether(Comparable a[], int lower, int upperEnd) {
		int lowerEnd = (lower + upperEnd) / 2;
		int upper = lowerEnd + 1;
		int tmp = lower;
		int numElements = upperEnd - lower + 1;
		Comparable tmpArray[] = new Comparable[a.length];
		
		while (lower <= lowerEnd && upper <= upperEnd) {
			if (a[lower].compareTo(a[upper]) < 0) {
				tmpArray[tmp++] = a[lower++];
			} else {
				tmpArray[tmp++] = a[upper++];
			}
		}
		while (lower <= lowerEnd) {
			tmpArray[tmp++] = a[lower++];
		}
		while (upper <= upperEnd) {
			tmpArray[tmp++] = a[upper++];
		}
		for (int i = 0; i < numElements; i++,upperEnd--) {
			a[upperEnd] = tmpArray[upperEnd];
		}
	}
}				
				
