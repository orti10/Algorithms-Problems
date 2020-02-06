package glassBalls;
public class GlassBallTriangle {

	public static int nearestTriangularNumber(int n){
		int x=0;
		double s = 1. + 8.*n;
		double k = Math.sqrt(s);
		int c = (int)k;
		if (c*c==s){
			x = (-1 + c)/2;
		}
		else{
			x = (int)((-1+k)/2.) + 1;
		}
		//System.out.println("nearest triangular of "+ n + ": t = " + x*(x+1)/2 + ", x = "+x);
		return x;
	}
	// floorPotential[0]>0 - the potential of the first floor 
	// if (floorPotential[i] >=  ballPotential) then the ball is broken
	public static void glassBallsTriangle(int []floorPotential, int ballPotential){
		//n = the number of floors, t - the current floor
		int n = floorPotential.length;
		int k = nearestTriangularNumber(n);
		int step = k, numChecks = 0, t = k-1;
		boolean isBroken = false;
		if (floorPotential[n-1] < ballPotential){// the first ball not broken
			System.out.println("the first ball is not broken");
			return;
		}
		// the first ball
		while(!isBroken && t < n){
			numChecks++;
			if (isCrashed(floorPotential[t], ballPotential)) isBroken = true;
			else t = t + (--step);
		}
		// the second ball
		if (t > n )t = t - k;
		else t = t - step + 1;
		isBroken = false;
		//  throw the second ball
		while(!isBroken){
			numChecks++;
			if (isCrashed(floorPotential[t], ballPotential)) isBroken = true;
			else t++;
		}
		System.out.println("k = "+k+", "+", numChecks = "+numChecks+", floor number =  "+(t+1));
	}
	public static boolean isCrashed(int floorPotential, int ballPotential){
		return floorPotential >= ballPotential;
	}
	public static void checkTriangularNumber(){
		nearestTriangularNumber(100);
		nearestTriangularNumber(50);
		nearestTriangularNumber(28);
		nearestTriangularNumber(10);
		nearestTriangularNumber(3);
	}
	public static void test1(){
		int size = 100, a=49;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		glassBallsTriangle(floorPotential, a);
	}
	public static void test2(){
		int size = 10, a=9;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		glassBallsTriangle(floorPotential, a);
	}
	public static void test3(){
		int size = 10, a=10;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		glassBallsTriangle(floorPotential, a);
	}
	public static void test4(){
		//n=11
		int [] floorPotential={3,5,8,14,15,18,27,32,35,40,44};
		int a = 12;
		glassBallsTriangle(floorPotential, a);
	}
	public static void test5(){
		//n=11
		int [] floorPotential={3,5,8,14,15,18,27,32,35,40,44};
		int a = 2;
		glassBallsTriangle(floorPotential, a);
	}
	public static void test6(){
		//n=11
		int [] floorPotential={3,5,8,14,15,18,27,32,35,40,44};
		int a = 45;
		glassBallsTriangle(floorPotential, a);
	}
	public static void main(String[] args) {
		//checkTriangularNumber();
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
}
