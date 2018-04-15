// Student Name: Ange Michaella Niyonkuru
// Student ID: 8962161
// Section C
// Assignment 3

public class Solution{
	private Cube[] cubes;
	private static int numberOfCalls;

	// constructors
	public Solution(Cube[] cubes){
		this.cubes=new Cube[cubes.length];
		for(int i=0;i<cubes.length;i++){
			this.cubes[i]=cubes[i].copy();
		}
	}
	public Solution(Solution other, Cube c){
		this.numberOfCalls=0;
		this.cubes=new Cube[other.size()+1];
		for(int i=0;i<other.size();i++){
			this.cubes[i]=other.cubes[i].copy();
		}
		this.cubes[other.size()]=c;
	}

	// setters and getters
	public static int getNumberOfCalls(){
		return numberOfCalls;
	}
	public static void resetNumberOfCalls(){
		numberOfCalls=0;
	}

	// other methods
	public int size(){
		if(this==null || this.cubes==null){
			return 0;
		}
		else{
			return this.cubes.length;
		}
	}
	public Cube getCube(int pos){
		return this.cubes[pos];
	}
	public boolean isValid(){
		numberOfCalls++;
		for(int i=0;i<this.size()-2;i++){
			for(int j=i+1;j<this.size()-1;j++){
				if (cubes[i].getFront()==cubes[j].getFront() 
					|| cubes[i].getRight()==cubes[j].getRight()
					|| cubes[i].getBack()==cubes[j].getBack()
					|| cubes[i].getLeft()==cubes[j].getLeft()){
					return false;
				}
			}
		}
		return true;
	}
	public boolean isValid(Cube next){
		numberOfCalls++;
		for(int i=0;i<this.size();i++){
			if(cubes[i].getFront()==next.getFront()
				|| cubes[i].getRight()==next.getRight()
				|| cubes[i].getBack()==next.getBack()
				|| cubes[i].getLeft()==next.getLeft()){
				return false;
			}
		}
		return true;
	}
	public String toString(){
		String strSolution="";
		for(int i=0;i<this.size();i++){
			strSolution+=cubes[i];
		}
		return strSolution;
	}
}