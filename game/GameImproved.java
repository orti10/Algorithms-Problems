package game;


public class GameImproved {
	public static void printArray(int [] arr, int i, int j){
		System.out.print("The numbers: ");
		for(int t=i; t<=j; t++) System.out.print(arr[t]+", ");
		System.out.println();
	}
	public static int gameAdaptive(int []arr){
		boolean even=true;
		int left=0, right=arr.length-1;
		int sumComputer=0,sumStudent=0, choice;
		int sumEven = 0, sumOdd = 0;
		for(int k=0; k<arr.length; k=k+2){
			sumEven = sumEven + arr[k];
			sumOdd = sumOdd + arr[k+1];
		}
		while(left < right){
			even=true;
			if (sumOdd > sumEven) even = false;
			else if (sumOdd == sumEven) {
				if(arr[left] > arr[right]) {
					if (left%2 == 0) even=true;
					else even = false;
				}
				else {//arr[left] <= arr[right]
					if (right%2 == 0) even=true;
					else even = false;
				}
			}
			if (left%2==0){
				if (even) {
					sumComputer = sumComputer + arr[left];
					sumEven = sumEven-arr[left++];
				}
				else{
					sumComputer = sumComputer + arr[right];
					sumOdd = sumOdd - arr[right--];
				}
			}
			else{// left odd
				if (even){
					sumComputer = sumComputer + arr[right];
					sumEven = sumEven - arr[right--];
				}
				else{
					sumComputer = sumComputer + arr[left];
					sumOdd = sumOdd - arr[left++];
				}
			}
			System.out.println("SUMMA - Computer: "+sumComputer+", Student: "+sumStudent);
			System.out.println();
			printArray(arr,left,right);
			choice = MyConsole.readInt("to choose left enter 0, to choose right enter 1: ");
			if (choice==0) {
				if (left%2 == 0) sumEven = sumEven - arr[left];
				else sumOdd = sumOdd - arr[left];
				sumStudent = sumStudent + arr[left++];			
			}
			else {
				if (right%2 == 0) sumEven = sumEven - arr[right];
				else sumOdd = sumOdd - arr[right];
				sumStudent = sumStudent + arr[right--];			
			}
		}
		return sumComputer-sumStudent;
	}
	// assumption: the array length is even
	// the computer chooses the first, the student chooses the second
	public static void main(String[] args) {
		System.out.println("THIS IS A GAME:");
		//int []arr = {7, 1, 3, 9, 6, 0, 3, 2, 2, 7};
		int []arr = {1,3,6,1,3,6};//profit=13-7=6
		//int []arr = {6, 0, 2, 7, 4, 4, 1, 3};//g2=14, gop=17
		printArray(arr, 0, arr.length-1);
		int profit = gameAdaptive(arr);
		System.out.println("profit = "+profit);
	}

}
