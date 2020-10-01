import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *	被Main.java调用的方法
 * @author ltc
 *
 */
//我试试看这段注释能不能更新上去
public class Methods {
	/*
	 * List<>属于提供了改变自身的方法的引用类型，即不是传值而是传引用
	 * 如果用了方法则可以改变值
	 * 但如果是用的赋值的=就不能改变值
	 */
	public void testList(List<Boolean> a){
		List<Boolean> b = new ArrayList<Boolean>();
		b.add(false);
		b.add(false);
		a = b;
	}
	
	public void testObjHashCode(){

		String a = "";
			a="";
			a = a+"";
			//System.out.println(Integer.toHexString(a.hashCode()));
			System.out.println(a+"的哈希码是"+Integer.toHexString(a.hashCode()));
	}
	
	/**
	 * 5.1-2这个算法调用RANDOM(0,1)实现RANDOM(a,b)，运行时间用O(log(b-a))
	 * @param a
	 * @param b
	 */
	public void Random(int a, int b){
		int c;
		if(b>=a)c=b-a;else c=a-b;
//		for(int )
		
	}
	/**
	 * 这段注释也是用来玩的，，，哈哈哈哈
	 * @author ltc
	 * 这段注释是用来玩的，，，哈哈哈哈
	 * 
	 * 这段注释还是用来玩的，，，哈哈哈哈
	 * @return 
	 */
	public int Random01(){
		if(Math.random()>0.5)
			return 1;
		else
			return 0;
	}
	
	/**
	 * @author ltc
	 * @param a
	 * @param b
	 * @param k 要求输入a和b都是2^k阶方阵，只管这一部分
	 */
	//学到了，说java方法不支持参数默认值
	public int[][] Strassen(int[][] A, int[][] B){
		System.out.println("Strassen算法因为不知道怎么搞下标标识子矩阵，就先不搞了");
		return A;
	}
	
	public void addBinary(boolean[] a, boolean[] b){
		int n = Math.max(a.length, b.length);
		boolean[] c = new boolean[n+1];
		//运算用int型做
		int A=0,B=0;
		for(int i=0; i<a.length; i++){
			A*=2;
			if(a[i])A++;
		}
		for(int i=0; i<b.length; i++){
			B*=2;
			if(b[i])B++;
		}
		int C = A+B;
		for(int i=n; i>=0; i--){
			if(C%2>0)c[i]=true;
			C/=2;
		}
		for(int i=0; i<n+1; i++){
			System.out.print(c[i]);
		}
		return;
	}
	
	/**
	 * 2.1-2
	 * @param A
	 * @param v
	 */
	public void linearSearch(int[] A, int v){
		for(int i=0; i<A.length; i++){
			if(A[i]==v){
				System.out.println(i);
				return;
			}
		}
		System.out.println("NIL");
		return;
	}
	
	public void insertionSort(int[] A){
		long startTime=System.nanoTime();
		for(int j=0; j<A.length; j++){
			int key = A[j];
			int i = j-1;
			while (i>=0 && A[i]>key){
				A[i+1] = A[i];
				i = i-1;
			}
			A[i+1] = key;
		}
		for(int i=0; i<A.length; i++)
			System.out.print(A[i]+"\t");

		long endTime=System.nanoTime();
		System.out.println("\n程序运行了"+(endTime-startTime)+"ns");
	}
	
	public void bitShift(int x){
		System.out.println(x>>1);
		System.out.println(x>>2);
		System.out.println(x<<1);
		System.out.println(x<<2);
	}
	public void numOfBits(int x){
		System.out.println(Integer.toBinaryString(x).length());
	}
	public int BigIntMulti(int x, int y){
		int sum = 0;
		if(x > y){
			int temp = x;
			x = y;
			y = temp;
		}
		int m = Integer.toBinaryString(x).length();
		int n = Integer.toBinaryString(y).length();
		for(int i = 0; i < n; i += m){
			sum = sum<<m;
			sum += Multi(y>>i%(1<<m), x);
			System.out.println("sum="+sum);
		}
		return sum;
	}

	boolean flag = false;
	public int Multi(int x, int y){//Multiply equal length integers
		if(x<0){
			flag = flag^true;
			x = -x;
		}
		if(y<0){
			flag = flag^true;
			y = -y;
		}
		int n = Integer.toBinaryString(x).length();
		if(n == 1)
			return x*y;
		System.out.println("x="+x+",y="+y+",n="+n);
		n/=2;
		int A = x>>n;
		int B = x%(1<<n);
		int C = y>>n;
		int D = y%(1<<n);
		System.out.println("A="+Integer.toBinaryString(A));
		System.out.println("B="+Integer.toBinaryString(B));
		System.out.println("C="+Integer.toBinaryString(C));
		System.out.println("D="+Integer.toBinaryString(D));
		int AC = Multi(A, C);
		System.out.println("AC="+Integer.toBinaryString(AC));
		int BD = Multi(B, D);
		System.out.println("BD="+Integer.toBinaryString(BD));
		System.out.println("A-B="+Integer.toBinaryString(A-B));
		System.out.println("D-C="+(D-C));
		int result = AC<<(2*n) + (Multi(A-B, D-C)+AC+BD)<<n + BD;
		if(flag) result = -result;
		return result;
	}


	public void print(String s){
		System.out.println(s);
	}
	
	public void Table(int k, int a[][]){
		int n = 1<<k;
		a = new int[n][n];
		for(int i = 0; i < n; i++){
			a[0][i] = i+1;
		}//填第0行
		try{
		for(int m = 1; m < n; m *= 2){//小块的大小
			for(int t = 0; t < n/(2*m); t++){
				for(int i = 0; i < m; i++){
				for(int j = 0; j < m; j++){
					a[m+i][(2*t+1)*m+j] = a[i][2*t*m+j];
					a[m+i][2*t*m+j] = a[i][(2*t+1)*m+j];
				}
				}
			}
		}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("here is an exception");
			for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(a[i][j]+" ");
			}System.out.println("");
			}
		}
		System.out.println("here is the answer");
		for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			System.out.print(a[i][j]+" ");
		}System.out.println("");
		}
	}
	
	public int BinarySearch(int[] a, int x,  int n){
		int left = 0, right = n-1;
		while(left <= right){
			int middle = (left+right)/2;
			if(x == a[middle])
				return middle;
			if(x > a[middle])
				left = middle+1;
			else
				right = middle-1;
		}
		return -1;
	}
	//2-3
	public int[] BinarySearchBounds(int[] a, int x, int n){
		//要找到大于x的最小元素位置，可以用BinarySearch的结果折半查找
		int result[] = {0,0};
		if(a[0] == x)
			result[0] = -1;
		if(a[n-1] == x)
			result[1] = -1;
		int search = BinarySearch(a, x, n);
		if(search == -1){
			result[0] = -1;
			result[1] = -1;
		}
		int left, right, middle = 0;
		if(result[0] == 0){
			left = 0;
			right = search;
			while(left <= right){
				middle = (left+right)/2;
				if(x > a[middle] && x == a[middle+1])//middle是出口
					left = right+1;
				else if(x > a[middle])//x<a[middle-1]
					left = middle;
				else if(x == a[middle+1])//x=a[middle]
					right = middle;
			}
			result[0] = middle;
		}
		if(result[1] == 0){
			left = search;
			right = n-1;
			while(left <= right){
				middle = (left+right)/2;
				if(x < a[middle] && x == a[middle-1])//middle是出口
					left = right+1;
				else if(x < a[middle])//x<a[middle-1]
					right = middle;
				else if(x == a[middle-1])//x=a[middle]
					left = middle+1;
			}
			result[1] = middle;
		}
		return result;
	}

	
}//Methods