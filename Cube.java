// Student Name: Ange Michaella Niyonkuru
// Student ID: 8962161
// Section C
// Assignment 3

public class Cube{
	private Color[] faces;
	private static final int NUMBER_OF_POSSIBLE_ORIENTATIONS=24;
	private Cube deepCopy;
	private String[] seenPositions;
	private int rotationNumber;
	private int newPositionsCounter;

	public Cube(Color[] faces){
		if(faces.length==6){
			this.faces=faces;
		}

		deepCopy=this.copy();

		rotationNumber=0;
		newPositionsCounter=0;
		seenPositions=new String[24];
		for(int i=0;i<seenPositions.length;i++){
			seenPositions[i]=null;
		}
	}
	// **************************************************************

	// deep copy
	public Cube(Cube other){
		this.faces=new Color[6];
		this.setUp(other.getUp());
		this.setFront(other.getFront());
		this.setRight(other.getRight());
		this.setBack(other.getBack());
		this.setLeft(other.getLeft());
		this.setDown(other.getDown());
	}
	public Cube copy(){
		Cube tempCube=new Cube(this);
		return tempCube;
	}
	// **************************************************************

	// getters
	public Color getUp(){
		return faces[0];
	}
	public Color getFront(){
		return faces[1];
	}
	public Color getRight(){
		return faces[2];
	}
	public Color getBack(){
		return faces[3];
	}
	public Color getLeft(){
		return faces[4];
	}
	public Color getDown(){
		return faces[5];
	}
	public String toString(){
		String s="["+this.getUp()+","
					+this.getFront()+","
					+this.getRight()+","
					+this.getBack()+","
					+this.getLeft()+","
					+this.getDown()+"]";
		return s;
	}
	// ***************************************************************

	// setters
	public void setUp(Color cUp){
		faces[0]=cUp;
	}
	public void setFront(Color cFront){
		faces[1]=cFront;
	}
	public void setRight(Color cRight){
		faces[2]=cRight;
	}
	public void setBack(Color cBack){
		faces[3]=cBack;
	}
	public void setLeft(Color cLeft){
		faces[4]=cLeft;
	}
	public void setDown(Color cDown){
		faces[5]=cDown;
	}
	// ***************************************************************

	// mechanism to iterate through the 24 possible orientations
	public boolean hasNext(){
		if(newPositionsCounter<NUMBER_OF_POSSIBLE_ORIENTATIONS){
			return true;
		}
		else{
			return false;
		}
	}
	public void next() throws IllegalStateException{
		rotationNumber++;
		switch (rotationNumber){
			case 1:{identity();
				break;
			}
			case 2:{rotate();
				break;
			}
			case 3:{rotate();
				break;
			}
			case 4:{rotate();
				break;
			}
			case 5:{rightRoll();
				break;
			}
			case 6:{rotate();
				break;
			}
			case 7:{rotate();
				break;
			}
			case 8:{rotate();
				break;
			}
			case 9:{rightRoll();
				break;
			}
			case 10:{rotate();
				break;
			}
			case 11:{rotate();
				break;
			}
			case 12:{rotate();
				break;
			}
			case 13:{leftRoll();
				break;
			}
			case 14:{rotate();
				break;
			}
			case 15:{rotate();
				break;
			}
			case 16:{rotate();
				break;
			}
			case 17:{leftRoll();
				break;
			}
			case 18:{rotate();
				break;
			}
			case 19:{rotate();
				break;
			}
			case 20:{rotate();
				break;
			}
			case 21:{rightRoll();
				break;
			}
			case 22:{rotate();
				break;
			}
			case 23:{rotate();
				break;
			}
			case 24:{rotate();
				break;
			}
		}
		boolean hasBeenSeenPosition=false;
		for(int i=0;i<newPositionsCounter;i++){
			if (seenPositions[i]==toString()){
				hasBeenSeenPosition=true;
				//System.out.println("This position has been seen");
				throw new IllegalStateException();
			}
		}
		if(!hasBeenSeenPosition){
			//System.out.println("About to add...:"+toString());
			//System.out.println("Element number... "+newPositionsCounter);
			seenPositions[newPositionsCounter]=toString();
			newPositionsCounter++;
		}
		
		//System.out.println("Position "+newPositionsCounter);
		
		// call appropriate rotation operation
		// get the new orientation
		// check if you saw it before
		// if yes throw an error !
	}
	public void reset(){
		identity();
		for(int i=0;i<24;i++){
			seenPositions[i]=null;
		}
		newPositionsCounter=0;
		rotationNumber=0;
	}
	// ***************************************************************

	// rotation operations
	public void rotate(){	// top and bottom stay the same
		Color previousFront, previousRight, previousBack, previousLeft;
		Cube tempCopy=copy();
		//System.out.println("Just created a deep copy, about to rotate");
		//System.out.println("getting faces..");
		previousFront=tempCopy.getFront();
		//System.out.println("front is: " + previousFront);
		previousRight=tempCopy.getRight();
		//System.out.println("right is: " + previousRight);
		previousBack=tempCopy.getBack();
		//System.out.println("back is: " + previousBack);
		previousLeft=tempCopy.getLeft();
		//System.out.println("left is: " + previousLeft);

		//System.out.println("setting faces...");
		setFront(previousLeft);
		//System.out.println("new front is: " + getFront() );
		setRight(previousFront);
		//System.out.println("new right is: " + getRight());
		setBack(previousRight);
		//System.out.println("new back is: " + getBack());
		setLeft(previousBack);
		//System.out.println("new left is: " + getLeft());

		tempCopy=null;
		previousFront=null;
		previousRight=null;
		previousBack=null;
		previousLeft=null;
	}
	public void rightRoll(){	// back and front stay the same
		Color previousUp, previousRight, previousLeft, previousDown;
		previousUp=this.getUp();
		previousRight=this.getRight();
		previousLeft=this.getLeft();
		previousDown=this.getDown();

		this.setUp(previousLeft);
		this.setRight(previousUp);
		this.setLeft(previousDown);
		this.setDown(previousRight);

		previousUp=null;
		previousRight=null;
		previousLeft=null;
		previousDown=null;
	}
	public void leftRoll(){		// back and front stay the same
		Color previousUp, previousRight, previousLeft, previousDown;
		previousUp=this.getUp();
		previousRight=this.getRight();
		previousLeft=this.getLeft();
		previousDown=this.getDown();

		this.setUp(previousRight);
		this.setRight(previousDown);
		this.setLeft(previousUp);
		this.setDown(previousLeft);

		previousUp=null;
		previousRight=null;
		previousLeft=null;
		previousDown=null;
	}
	public void identity(){		// goes back to the initial state
		this.setUp(deepCopy.getUp());
		this.setFront(deepCopy.getFront());
		this.setRight(deepCopy.getRight());
		this.setBack(deepCopy.getBack());
		this.setLeft(deepCopy.getLeft());
		this.setDown(deepCopy.getDown());
	}
	// ***************************************************************
}