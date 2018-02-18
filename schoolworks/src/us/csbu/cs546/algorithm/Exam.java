package us.csbu.cs546.algorithm;

public class Exam {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi - lo <= 1)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi); // Sorts a[lo..hi-1].
		System.out.print(lo + " " + hi + " ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		sort(a, aux, 0, N - 1);
	}

	// is v < w ?
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	@SuppressWarnings("rawtypes")
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	@SuppressWarnings({ "rawtypes" })
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}

		// postcondition: a[lo .. hi] is sorted
		assert isSorted(a, lo, hi);
	}

	public static void main(String args[]) {
		Character[] a = { 'y', 'i', 'b', 'w', 'l', 'o', 'l' };
		sort(a);
	}
	// run Character[] a = { 'y', 'i', 'b', 'w', 'l', 'o', 'l' };
	// 1 3 y b i w l o l
	// 4 6

}
