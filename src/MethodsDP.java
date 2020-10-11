import java.util.ArrayList;
import java.util.Arrays;
/**
 * @time 2020年10月11日18:17:10
 * @author ltc
 *
 */
public class MethodsDP {
	void LcsLength(int x[], int[] y){
		int m = x.length;
		int n = y.length;
		int[][] c = new int[m+1][n+1];
		for(int i = 1; i <= m; i ++){
			for(int j = 1; j <= n; j ++){
				if(x[i-1] == y[j-1]){
					c[i][j] = c[i-1][j-1] + 1;
				}
				else if(c[i-1][j] >= c[i][j-1])
					c[i][j] = c[i-1][j];
				else
					c[i][j] = c[i][j-1];
			}
		}
		System.out.println("子序列的LCS长度表");
		for(int i = 0; i <= m; i ++){
			for(int j = 0; j <= n; j ++){
				System.out.print(c[i][j]+"\t");
			}System.out.println();
		}
		System.out.println("构造LCS");
		PrintLcs(c, x, m, n);
	}
	void PrintLcs(int[][] c, int[] x, int i, int j){
		if(i == 0 || j == 0)
			return;
		if(c[i][j] == c[i-1][j-1] + 1){
			PrintLcs(c, x, i-1, j-1);
			System.out.print(x[i-1]+"\t");
		}
		else if(c[i-1][j] >= c[i][j-1])
			PrintLcs(c, x, i-1, j);
		else
			PrintLcs(c, x, i, j-1);
	}
	
	class ExtendedMemoizedCutRodResult{
		@Override
		public String toString() {
			return "ExtendedMemoizedCutRodResult [q=" + q + ", s=" + s + "]";
		}
		public ExtendedMemoizedCutRodResult(int q, ArrayList<Integer> s) {
			super();
			this.q = q;
			this.s = s;
		}
		int q;
		ArrayList<Integer> s;
	}
	ExtendedMemoizedCutRodResult ExtendedMemoizedCutRod(int[] p, int n){
		int[] r = new int[n+1];//r是备忘录
		ArrayList<Integer> s = new ArrayList<Integer>(); 
		for(int i = 0; i <= n; i ++)
			r[i] = -1;
		int q = ExtendedMemoizedCutRodAux(p, n, r, s);
		return new ExtendedMemoizedCutRodResult(q, s);
	}

	int ExtendedMemoizedCutRodAux(int[] p, int n, int[] r, ArrayList<Integer> s){
		if(r[n] >= 0)
			return r[n];
		int q;
		if(n == 0)
			q = 0;
		else{
			q = -1;
			s.add(-1);
			int i;
			for(i = 1; i <= n; i ++){
				int copy = q;
				q = Math.max(q, p[i] + MemoizedCutRodAux(p, n-i, r));
				if(copy != q)s.set(s.size() - 1, i);
			}
				
		}
		int sum = 0;
		for(int i = 0; i < s.size(); i++){
			sum += s.get(i);
		}
		if(n != sum)s.add(n - sum);
		r[n] = q;
		return q;
	}
	
	/**
	 * 这次要考虑切割成本了
	 * @param p
	 * @param n
	 * @return
	 */
	ExtendedCutRodResult ExtendedBottomUpCutRod2(int[] p, int n, int c){
		//仍然符合最优子结构性质，但是判断是否写入的时候，i=j的情况要特殊处理
		int[] r = new int[n+1];
		int[] s = new int[n+1];
		r[0] = 0;
		for(int j = 1; j <= n; j++){//j从1到n填写r和s
			int q = -1;
			int i;//只要i<j就都是要加成本的，原来选法可以不变
			for(i = 1; i < j; i ++){//i从1到j-1对子问题选取最优化的方案
				if(q < p[i] + r[j-i]){
					q = p[i] + r[j-i];
					s[j] = i;
				}
			}
			if(i==j){
				if(q - c< p[i] + r[j-i]){//要割的比起不用割的少赚了割一下的成本
					q = p[i] + r[j-i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return new ExtendedCutRodResult(r,s);
	}
	
	class ExtendedCutRodResult{
		@Override
		public String toString() {
			return "ExtendedCutRodResult [r=" + Arrays.toString(r) + ", s=" + Arrays.toString(s) + "]";
		}
		public ExtendedCutRodResult(int[] r, int[] s) {
			super();
			this.r = r;
			this.s = s;
		}
		int[] r;
		int[] s;//s保存最优解对应第一段钢条的切割长度
	}
	ExtendedCutRodResult ExtendedBottomUpCutRod(int[] p, int n){
		int[] r = new int[n+1];
		int[] s = new int[n+1];
		r[0] = 0;
		for(int j = 1; j <= n; j++){//j从1到n填写r和s
			int q = -1;
			for(int i = 1; i <= j; i ++){//i从1到j对子问题选取最优化的方案
				if(q < p[i] + r[j-i]){
					q = p[i] + r[j-i];
					s[j] = i;
				}
			}
			r[j] = q;
		}
		return new ExtendedCutRodResult(r,s);
	}
	
	/**
	 * 自底向上Fibonacci，不是动态规划，但是备忘录是一样的
	 * 比起动态规划少了一个“最优化”
	 * @param n
	 * @return
	 */
	int BottomUpFibonacci(int n){
		int[] r = new int[n+1];
		r[0] = 1;
		r[1] = 1;
		for(int i = 2; i <= n; i ++)
			r[i] = r[i-1] + r[i-2];
		return r[n];
		}
	/**
	 * 自底向上切割钢条，动态规划
	 * 代码并不复杂，但是抽象过程我不清楚
	 * @param p
	 * @param n
	 * @return
	 */
	int BottomUpCutRod(int[] p, int n){
		int[] r = new int[n+1];
		r[0] = 0;
		for(int j = 1; j <= n; j ++){
			int q = -1;
			for(int i = 1; i <= j; i ++){
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		return r[n];
		//像斐波那契
	}
	
	
	/**
	 * 带备忘录的自顶向下递归
	 * @param p
	 * @param n
	 * @return
	 */
	int MemoizedCutRod(int[] p, int n){
		int[] r = new int[n+1];//r是备忘录
		for(int i = 0; i <= n; i ++)
			r[i] = -1;
		return MemoizedCutRodAux(p, n, r);//auxiliary辅助的
		//直接递归的部分另写一个方法
	}
	int MemoizedCutRodAux(int[] p, int n, int[] r){
		if(r[n] >= 0)
			return r[n];
		int q;
		if(n == 0)
			q = 0;
		else{
			q = -1;
			for(int i = 1; i <= n; i ++)
				q = Math.max(q, p[i] + MemoizedCutRodAux(p, n-i, r));
		}
		r[n] = q;
		return q;
	}
	int CutRod(int[] p, int n){//0开头，最大n不是p.length
		//递归
		if(n == 0)
			return 0;
		int q = 0;
		for(int i = 1; i <= n; i ++){
			q = Math.max(q, p[i] + CutRod(p,n-i));
		}
		return q;
	}
	
	
	/**
	 * 矩阵连乘问题动态规划
	 * @author ltc
	 * @time 2020年10月7日22:50:32
	 * @param p
	 * @param m
	 * @param s
	 */
	MatrixChainResult MatrixChain(int[] p){
		int n = p.length;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		for(int i = 0; i < n; i++)
			m[i][i] = 0;//写主对角线
		for(int r = 2; r < n; r++){//子链长度为r
			for(int i = 1; i < n - r + 1; i++){//同长度子链的第i段
				int j = i + r - 1;//子链末元素序号
				m[i][j] = m[i][i] + m[i+1][j] + p[i-1]*p[i]*p[j];
				s[i][j] = i;
				for(int k = i+1; k < j; k++){
					int t = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
					if(t < m[i][j]){
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
		return new MatrixChainResult(m,s);
	}
	
	public class MatrixChainResult{
		@Override
		public String toString() {
			return "MatrixChainResult [m=" + Arrays.toString(m) + ", s=" + Arrays.toString(s) + "]";
		}
		int[][] m;
		int[][] s;
		MatrixChainResult(int[][] m, int[][] s) {
			this.m = m;
			this.s = s;
		}
		
	}
}
