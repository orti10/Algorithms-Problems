package game;


public class Game {
	public static int[] randArray(int size){
		int [] arr = new int[size];
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random()*arr.length*10);
		}
		return arr;
	}
	public static void printArray(int [] arr, int i, int j){
		System.out.print("The numbers: ");
		for(int t=i; t<=j; t++){
			System.out.print(arr[t]+", ");
		}
		System.out.println();
	}

	public static void game(int []arr){
		// assumption: the array length is even
		// the computer chooses the first, the student chooses the second
		System.out.println("THIS IS A GAME:");
		printArray(arr, 0, arr.length-1);
		int sumEven = 0, sumOdd = 0;
		int left=0, right=arr.length-1;
		boolean even=true;
		for(int k=0; k<arr.length; k=k+2){
			sumEven = sumEven + arr[k];
			sumOdd = sumOdd + arr[k+1];
		}
		if (sumEven<sumOdd) even = false;
		int sumComputer=0,sumStudent=0, choice, second;
		while(left<right){
			if (left%2==0){
				if (even){
					System.out.println("Computer: I take the first: "+arr[left]);
					sumComputer = sumComputer + arr[left++];
				}
				else{
					System.out.println("Computer: I take the last: "+arr[right]);
					sumComputer = sumComputer + arr[right--];
				}
			}
			else{// left odd
				if (even){
					System.out.println("Computer: I take the last: "+arr[right]);
					sumComputer = sumComputer + arr[right--];
				}
				else{
					System.out.println("Computer: I take the first: "+arr[left]);
					sumComputer = sumComputer + arr[left++];
				}
			}
			System.out.println("SUMMA - Computer: "+sumComputer+", Student: "+sumStudent);
			System.out.println();
			printArray(arr,left,right);
			choice = MyConsole.readInt("to choose left enter 0, to choose right enter 1: ");
			if (choice==0) second = left++;
			else second = right--;
			sumStudent = sumStudent + arr[second];
		}		
		System.out.println("Congratulations!   Computer="+sumComputer+", Student="+sumStudent);
	}
	////////////////////////////////************
	public static void main(String[] args) {
		int size = 8;
		int arr[] = {1,3,6,1,3,6};
		//int arr[] = randArray(size);
		game(arr);
	}
}
