package lcs;

import java.util.HashSet;

public class LCS_DinamicProgStrings {
	// the function returns max common sequence length
	public static int[][] buldMatrix(String X, String Y) {
		// build matrix of numbers
		int row = X.length()+1,  col = Y.length()+1;
		int mat[][] = new int[row][col]; 
		int i=0, j=0;
		// first column
		for (i=0; i<row; i++) mat[i][0]=0;
		// first row
		for (j=0; j<col; j++) mat[0][j]=0;
		// Matrix Interior 
		for (i=1; i<row; i++) {
			for (j=1; j<col; j++) {
				if (X.charAt(i-1)==Y.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1] + 1;
				}
				else{
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return mat;
	}
	public static int lcsMaxLength(String X, String Y){
		int[][] mat = buldMatrix(X, Y);
		return mat[X.length()-1][Y.length()-1];
	}
	// the function returns max common sequence of two integer sequences
	public static String maxSequence(String X, String Y){
		// the function returns max common sequence of two integer sequences
		int mat[][] = buldMatrix(X, Y); 
		//MyLibrary.printIntMatrix(mat);
		int row = mat.length;
		int col = mat[0].length;
		int seqLength = mat[row-1][col-1];
		String result = new String();
		int i=row-1, j=col-1, count=seqLength-1;
		while (count>=0){
			if (X.charAt(i-1)==Y.charAt(j-1)){
				result = X.charAt(i-1) + result;
				i--;
				j--;
				count--;
			}
			else if (mat[i][j]==mat[i][j-1]) j--;
			else  i--;
		}
		return result;
	}
	// one longest common sequence recursive implementation
	public static String maxSequenceRecursiv(String X, String Y){
		int mat[][] = buldMatrix(X, Y);
		String ans = maxSequenceRecursiv(X, Y, X.length(), Y.length(), mat);
		if (ans.length() > 0) return ans;
		return "";
	}
	public static String maxSequenceRecursiv(String X, String Y, int i, int j, int[][] mat){
		if (i <= 0 || j <= 0)
			return "";		
		else if  (X.charAt(i-1) == Y.charAt(j-1))
			return maxSequenceRecursiv(X, Y, i-1, j-1, mat) + X.charAt(i-1);
		else
			if (mat[i][j-1] > mat[i-1][j])
				return maxSequenceRecursiv(X, Y, i, j-1, mat);
			else
				return maxSequenceRecursiv(X, Y, i-1, j, mat);
	}
	public static HashSet<String> lcsAll(String X, String Y){
		int[][]mat = buldMatrix(X, Y);
		HashSet<String> set = lcsAll(mat, X, Y, X.length(), Y.length());
		return set;
	}
	public static HashSet<String> lcsAll(int[][]m, String s1, String s2, int i, int j) {
		if (i == 0 || j == 0) {
			HashSet<String> set = new HashSet<String>();
			set.add("");
			return set;
		}
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			HashSet<String> set = lcsAll(m, s1, s2, i - 1, j - 1);
			HashSet<String> set1 = new HashSet<>();
			for (String temp : set) {
				temp = temp + s1.charAt(i - 1);
				set1.add(temp);
			}
			return set1;
		} 
		else {
			HashSet<String> set = new HashSet<>();
			HashSet<String> set1 = new HashSet<>();
			if (m[i - 1][j] >= m[i][j - 1]) {
				set = lcsAll(m, s1, s2, i - 1, j);
			}
			if (m[i][j - 1] >= m[i - 1][j]) {
				set1 = lcsAll(m, s1, s2, i, j - 1);
			}
			for (String temp : set) {
				set1.add(temp);
			}
			return set1;
		}

	}	
	public static void main(String[] args) {
		String Y1 = "abcbdab", X1  = "bdcaba"; 
		System.out.println(lcsAll(X1,Y1));

		String X2 = "abca", Y2 = "bcb";
		System.out.println(lcsAll(X2,Y2));

		String X3 = "abcat", Y3 = "abcba";
		System.out.println(lcsAll(X3,Y3));

		String X4 = "abcab", Y4 = "bcb";
		System.out.println(lcsAll(X4,Y4));

		String X5 = "abcab", Y5 = "abcab";
		System.out.println(lcsAll(X5,Y5));

		String X6 = "abcab", Y6 = "qwer";
		System.out.println(lcsAll(X6,Y6));

		String X7 = "abca", Y7 = "acb";
		System.out.println(lcsAll(X7,Y7));
	}
}
