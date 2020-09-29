/**
 *	被Main.java调用的方法
 * @author ltc
 *
 */
//我试试看这段注释能不能更新上去
public class Methods {
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