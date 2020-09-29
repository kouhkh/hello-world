/**
 * Main·½·¨
 * @author ltc
 *
 */
public class Main {
	public static void main(String args[]) {
		Methods m = new Methods();
/*		m.print("Hello, world.");
		int[][] a = null;
		m.Table(4, a);
*/
		int[] a = {1,2,3,4,4,5,6,6,6,7,8};
		int x = 9;
		//System.out.println(m.BinarySearch(a, x, a.length));
		System.out.println(m.BinarySearchBounds(a, x, a.length)[0]);
		System.out.println(m.BinarySearchBounds(a, x, a.length)[1]);
	}
}