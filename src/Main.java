import java.util.ArrayList;
import java.util.List;

/**
 * Main方法
 * @author ltc
 *
 */
public class Main {
	public static void main(String args[]) {
		MethodsDP m = new MethodsDP();
		//int[] p = new int[]{0,1,5,8,9,10,17,17,20,24,30};
		//System.out.println(m.ExtendedBottomUpCutRod(p,10));
		//System.out.println(m.ExtendedBottomUpCutRod2(p,10,4));
		//System.out.println(m.BottomUpFibonacci(15));
		//System.out.println(m.ExtendedMemoizedCutRod(p, 7)); 
		int[] x = {1,0,0,1,0,1,0,1}, y = {0,1,0,1,1,0,1,1,0};
		m.LcsLength(x, y);
	}
}




//2020年10月11日10:13:50
//int[] p = {4,5,5,8,3,2,5,1};
//Methods.MatrixChainResult r = m.MatrixChain(p);
//for(int i = 1;i<p.length;i++){
//	for(int j = 1;j<p.length;j++){
//		System.out.print(r.m[i][j] + "\t");
//	}System.out.println();
//}
//System.out.println();
//for(int i = 1;i<p.length;i++){
//	for(int j = 1;j<p.length;j++){
//		System.out.print(r.s[i][j] + "\t");
//	}System.out.println();







