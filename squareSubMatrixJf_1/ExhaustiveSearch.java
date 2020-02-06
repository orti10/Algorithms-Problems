package squareSubMatrixJf_1;

public class ExhaustiveSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int mat[][] = {{0,0,0,1,0}, {1,1,1,1,0}, {0,1,1,1,1},
				{1,1,1,1,0},{1,1,0,0,1}};
		int mat1[][] = {{0,0,1,0},{0,0,1,1},{0,0,1,1},{1,1,1,1}};
		int mat2[][] = {{0,1,1},{1,1,0},{1,1,0}};
		exhaustiveSearch2(mat1);
	}
	///Exhaustive Search
	public static void exhaustiveSearch2(int[][]mat){
		int n = mat.length;
		int iStart = 0, jStart = 0, iEnd = 0, jEnd = 0;
		int maxDim = 0;
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				if (mat[i][j]==1) {
					int k = 1, p=i+k, q=j+k;				
					while (p<n && q<n){
						if(checkForOne(mat,i,j,p,q) && k+1 > maxDim){
							iStart = i;  jStart = j;
							iEnd = p;  jEnd = q;
							maxDim = k+1;
						}
						k = k + 1;
						p = i + k; q = j + k;
					}
				}
			}	
		}
		if (iEnd==n) iEnd--;
		if (jEnd==n) jEnd--;
		
		System.out.println(" maxDim: "+maxDim+", iStart=" + iStart+", jStart="+jStart+", iEnd="+iEnd+", jEnd="+jEnd);
	}
	public static boolean checkForOne(int [][]mat, int iStart, int jStart, int iEnd, int jEnd){
		boolean ans = true;
		for (int i=iStart; ans && i<=iEnd; i++){
			for (int j = jStart; ans && j<=jEnd; j++){
				if (mat[i][j] == 0) ans = false;
			}
		}
		return ans;
	}
}
