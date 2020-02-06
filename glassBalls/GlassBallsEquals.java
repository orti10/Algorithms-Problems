package glassBalls;

public class GlassBallsEquals {
	public static int nearestSquareNumber(int n){
		double k = Math.sqrt(n);
		int c = (int)k;
		if (c*c != n) c = c+1;
		return c;
	}
	public static void glassBallsEquals(int []floorPotential, int ballPotential){
		//n = the number of floors, t - the current floor
		int n = floorPotential.length;
		int step = nearestSquareNumber(n);
		int numChecks = 0, t = step-1;
		boolean isBroken = false;
		if (floorPotential[n-1] < ballPotential){// the first ball not broken
			System.out.println("the first ball is not broken");
			return;
		}
		// the first ball
		while(!isBroken && t < n){
			numChecks++;
			if (isCrashed(floorPotential[t], ballPotential)) isBroken = true;
			else t = t + step;
		}
		// the second ball
		if (t >= n ) t = t - step + 1;
		isBroken = false;
		//  throw the second ball
		while(!isBroken){
			numChecks++;
			if (isCrashed(floorPotential[t], ballPotential)) isBroken = true;
			else t++;
		}
		System.out.println("step = "+step+", "+", numChecks = "+numChecks+", floor number =  "+(t+1));
	}
	public static boolean isCrashed(int floorPotential, int ballPotential){
		return floorPotential >= ballPotential;
	}
	
	public static void checkNearestSquareNumber(){
		System.out.println(nearestSquareNumber(10));
		System.out.println(nearestSquareNumber(9));
		System.out.println(nearestSquareNumber(100));
		System.out.println(nearestSquareNumber(200));
	}
	public static void test1(){
		int size = 100, a=49;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		glassBallsEquals(floorPotential, a);
	}
	public static void test2(){
		int size = 100, a=50;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		glassBallsEquals(floorPotential, a);
	}
	public static void test3(){
		int size = 100, a=41;
		int [] floorPotential = new int[size];
		for(int i=0; i<size; i++){
			floorPotential[i] = i+1;
		}
		glassBallsEquals(floorPotential, a);
	}
	public static void test4(){
		//n=11
		int [] floorPotential={3,5,8,14,15,18,27,32,35,40,44};
		int a = 9;
		glassBallsEquals(floorPotential, a);
	}
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		test4();
	}
}
