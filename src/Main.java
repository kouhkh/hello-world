import java.util.ArrayList;
import java.util.List;

/**
 * Main方法
 * @author ltc
 *
 */
public class Main {
	public static void main(String args[]) {
		Methods m = new Methods();
		//m.Strassen(null, null);
		//m.testObjHashCode();
		//System.out.println(m.Random01());
//		for(int i = 50; i >0; i/=2){
//			System.out.println(i);
//		}
		List<Boolean> a = new ArrayList<Boolean>();
		a.add(true);
		a.add(false);
		m.testList(a);
		System.out.println(a.get(0));
		System.out.println(a.get(1));
	}
}