package aeroplane;

public class Node{
	int x, y, price, price2, numOfPaths;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.price = 0;
		this.price2 = 0;
		this.numOfPaths = 0;
	}
	public String toString(){
		return "("+x+","+y+") ";
//		return "x="+x+", y="+y+", price="+price+", np="+numOfPaths+"; ";
	}
}// class Node

