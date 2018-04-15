// Student Name: Ange Michaella Niyonkuru
// Student ID: 8962161
// Section C
// Assignment 3

public class Solve{
	private static Cube[] cubes=new Cube[4];

	public static LinkedQueue<Solution> generateAndTest(){
		// reset the statistics
		// generate all possible solutions
		// put valid solutions in a queue
		// print number of calls to isValid
		// return the queue

		LinkedQueue<Solution> solutionQueue=new LinkedQueue<Solution>();

		boolean validOrientation;

		Solution.resetNumberOfCalls();
		for(int firstCubeOrientation=0;firstCubeOrientation<24;firstCubeOrientation++){
			// try to change the first cube orientation, catch exception
			validOrientation=false;
			while(!validOrientation){ 	// while this positiion hasn't been seen
				try{
					cubes[0].next();
					validOrientation=true;
				}
				catch(IllegalStateException e){
					cubes[0].next();
				}
			}
			for(int secondCubeOrientation=0;secondCubeOrientation<24;secondCubeOrientation++){
				// try to change the second cube orientation, catch exception
				validOrientation=false;
				while(!validOrientation){
					try{
						cubes[1].next();
						validOrientation=true;
					}
					catch(IllegalStateException e){
						cubes[1].next();
					}
				}
				for(int thirdCubeOrientation=0;thirdCubeOrientation<24;thirdCubeOrientation++){
					// try to change the third cube orientation, catch exception
					validOrientation=false;
					while(!validOrientation){
						try{
							cubes[2].next();
							validOrientation=true;
						}
						catch(IllegalStateException e){
							cubes[2].next();
						}
					}
					for(int fourthCubeOrientation=0;fourthCubeOrientation<24;fourthCubeOrientation++){
						// try to change the fourth cube orientation, catch exception
						validOrientation=false;
						while(!validOrientation){
							try{
								cubes[3].next();
								validOrientation=true;
							}
							catch(IllegalStateException e){
								cubes[3].next();
							}
						}
						//System.out.println("cubes length is: "+cubes.length);
						Solution tempSolution=new Solution(cubes);
						if(tempSolution.isValid()){
							solutionQueue.enqueue(tempSolution);
						}
						// try to change the fourth cube orientation, catch exception
						// build solution
						// add solution to queue if valid
					}
					cubes[3].reset();
				}
				cubes[2].reset();
			}
			cubes[1].reset();
		}
		System.out.println("Total number of calls to isValid: " + Solution.getNumberOfCalls());
		return solutionQueue;
	}

	public static LinkedQueue<Solution> breadthFirstSearch(){
		// resets the statistic for counting the number of calls to isValid
		// find all valid solutions
		// print the total number of calls to isValid
		Solution.resetNumberOfCalls();
		LinkedQueue<Solution> result=new LinkedQueue<Solution>();
		// put in the queue the 24 orientations of the first cube
		cubes[0].reset();
		for(int i=0;i<24;i++){
			cubes[0].next();
			Cube[] cubesArr=new Cube[] {cubes[0]};
			Solution tempSolution=new Solution(cubesArr);
			result.enqueue(tempSolution);
		}

		// the start of the queue-based algorithm seen in class
		Solution dequeuedSolution=result.dequeue();
		while(dequeuedSolution.size()<=3){
			for(int i=0;i<24;i++){
				cubes[dequeuedSolution.size()].next();
				if(dequeuedSolution.isValid(cubes[dequeuedSolution.size()])){
					result.enqueue(new Solution(dequeuedSolution,cubes[dequeuedSolution.size()]));
				}
			}
			cubes[dequeuedSolution.size()].reset();
			dequeuedSolution=result.dequeue();
		}

		System.out.println("Total number of calls to isValid: " + Solution.getNumberOfCalls());
		return result;
	}

	public static void main(String[] args){
		StudentInfo.display();

		// populating the cubes array
		Color[] firstCubeFaces=new Color[] {Color.BLUE,Color.GREEN,Color.WHITE,Color.GREEN,Color.BLUE,Color.RED};
		Color[] secondCubeFaces=new Color[] {Color.WHITE,Color.GREEN,Color.BLUE,Color.WHITE,Color.RED,Color.RED};
		Color[] thirdCubeFaces=new Color[] {Color.GREEN,Color.WHITE,Color.RED,Color.BLUE,Color.RED,Color.RED};
		Color[] fourthCubeFaces=new Color[] {Color.BLUE,Color.RED,Color.GREEN,Color.GREEN,Color.WHITE,Color.WHITE};
		cubes[0]=new Cube(firstCubeFaces);
		cubes[1]=new Cube(secondCubeFaces);
		cubes[2]=new Cube(thirdCubeFaces);
		cubes[3]=new Cube(fourthCubeFaces);

		long start, stop;

		System.out.println("generateAndTest:");
		start=System.currentTimeMillis(); 

		generateAndTest();

		stop=System.currentTimeMillis();
		System.out.println("Ellapsed time: "+(stop-start)+" milliseconds");

		System.out.println("breadthFirstSearch:");
		start=System.currentTimeMillis();

		breadthFirstSearch();

		stop=System.currentTimeMillis();
		System.out.println("Ellapsed time: "+(stop-start)+" milliseconds");
	}
}