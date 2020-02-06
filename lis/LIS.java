package lis;
import java.util.Arrays;
import lcs.LCS_DynamicProgArrays;
public class LIS {
	// binary search between in array
	public static int binarySearchBetween(int []arr, int end, int value){
		/**
	if value<arr[0] the function returns zero
	if value>arr[end] the function returns  end+1
	if arr[index-1] < value < arr[index]
	the function returns index,
		 */
		int low = 0, high = end;
		if (value<arr[0]) return 0;
		if (value>arr[end])  return end+1;
		while (low <=high){
			int middle = (low + high)/2;
			if (low == high) {// stop search
				return low;
			}
			else {
				if (arr[middle] == value){//value was found
					return middle;
				}
				if (value < arr[middle]){// value suppose to be left
					high = middle;
				}
				else{// value suppose to be right
					low = middle+1;
				}
			}
		}
		return -1;
	}
	// binary search between in diagonal of matrix
	public static int binarySearchBetween(int [][]arr, int end, int value){
		/**
	if value<arr[0] the function returns zero
	if value>arr[end] the function returns  end+1
	if arr[index-1] < value < arr[index]
	the function returns index,
		 */
		int low = 0, high = end;
		if (value<arr[0][0]) return 0;
		if (value>arr[end][end])  return end+1;
		while (low <=high){
			int middle = (low + high)/2;
			if (low == high) {// stop search
				return low;
			}
			else {
				if (arr[middle][middle] == value){//value was found
					return middle;
				}
				if (value < arr[middle][middle]){// value suppose to be left
					high = middle;
				}
				else{// value suppose to be right
					low = middle+1;
				}
			}
		}
		return -1;
	}
	// array contains different integer numbers,assumption: arr.length>2
	// calculation of the length of largest increment subsequence
	public static int LISLength(int [] arr){
		int size = arr.length;
		int d[] = new int[size];
		d[0] = arr[0];
		int end = 0;
		for (int i=1; i<size; i++){
			int index = binarySearchBetween(d, end, arr[i]);
			d[index] = arr[i];
			if (index>end) end++;
		}
		return end+1;
	}
	public static int[] LIS2(int [] arr){
		int size = arr.length;
		int mat [][] = new int[size][size];
		mat [0][0] = arr[0];
		int end = 0;
		for (int i=1; i<size; i++){
			int index = binarySearchBetween(mat, end, arr[i]);
			//System.out.println("i = "+i+", index = "+index + ", element = "+arr[i]);
			for(int j=0; j<index; j++){
				mat[index][j]=mat[index-1][j];
			}
			mat[index][index] = arr[i];
			if (index>end) end++;
			//MyLibrary.printIntMatrix(mat);
			//System.out.println();
		}
		int ans[] = new int[end+1];
		for(int j=0; j<=end; j++) ans[j]=mat[end][j];
		return ans;
	}
	// the longest decreasing sequence
	public static int[] LDS2(int [] arr){
		int t[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			t[i] = -arr[i];
		}
		int []ans = LIS2(t);
		for (int i = 0; i < ans.length; i++) {
			ans[i] = -ans[i];
		}
		return ans;
	}
	public static int[] LIS2_Greedy(int [] arr){
		int[] t = new int[arr.length];
		t[0] = arr[0];
		int k = 0;
		for(int i=1; i<arr.length; i++){
			if (arr[i] > t[k]){
				t[++k] = arr[i];
			}
		}
		int[]ans = new int[k+1];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = t[i];
		}
		return ans;
	}
	public static int[] LIS2_with_LCS(int [] arr){
		int[]c = Arrays.copyOf(arr, arr.length);
		Arrays.sort(c);
		int[] ans = LCS_DynamicProgArrays.maxSequence(c, arr);
		return ans;
	}
	// exhaustive search
	public static void plus1(int[] arr){
		int i=arr.length-1;
		while( i>=0 && arr[i]==1){
			arr[i--] = 0;
		}
		if (i>=0) arr[i] = 1;
	}
	public static int[] LIS2_ExhaustiveSearch(int[]arr){
		int count = (int)Math.pow(2, arr.length)-1;
		int bin[] = new int[arr.length];
		int[]ans={};
		int maxLen = 0;
		for (int i=0; i<count; i++){
			plus1(bin);
			int [] temp = new int[arr.length];
			boolean flag = true;
			int k=0;
			for (int j=0; flag && j<arr.length; j++){
				if (bin[j] == 1){
					if (k >= 1){
						if (temp[k-1] < arr[j]){
							temp[k++] = arr[j];
						}
						else flag = false;
					}
					else temp[k++] = arr[j];
				}
			}
			if (flag){
				if (k>maxLen){
					ans = temp;
					maxLen = k;
				}
			}
		}
		int [] res = new int[maxLen];
		for (int j = 0; j < res.length; j++) {
			res[j] = ans[j];
		}
		return res;

	}
	public static void main(String[] args) {
		int[]arr = {-3, -2, 101, 9, 10, 11, 1, 2, 3, 100, 4, -1, 5, 6};
		System.out.println(Arrays.toString(LDS2(arr)));
	}
}
