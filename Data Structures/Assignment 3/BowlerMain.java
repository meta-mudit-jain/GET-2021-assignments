
import java.util.*; 

public class BowlerMain { 
	public static void main(String[] args){ 
		Scanner in = new Scanner(System.in); 

		int noOfBowler, totalNoOfBallsRemainingForViratKohli;

		System.out.println("Enter Total No of bowlers");
		noOfBowler = in.nextInt();
		System.out.println("Enter total no of balls played by virat kohli");
		totalNoOfBallsRemainingForViratKohli = in.nextInt();
		// Creating Priority queue constructor having
		// initial capacity=5 and a bowlerComparator instance
		// as its parameters
		PriorityQueue<Bowler> pq = new PriorityQueue<Bowler>(5, new BowlerComparator()); 
		System.out.println("Enter quoat of each bowler");
		for(int i=0;i<noOfBowler; i++)
		{
			System.out.println("Bowler No"+(i+1));
			int currentBowlerRemainingBallsLeft = in.nextInt();
			pq.add(new Bowler(i, currentBowlerRemainingBallsLeft));
		}
		System.out.println("Bowlers served in their priority order");
		while (!pq.isEmpty() && totalNoOfBallsRemainingForViratKohli > 0) { 
			System.out.println(pq.peek().getbowlerId()); 
			totalNoOfBallsRemainingForViratKohli -=  pq.poll().getBowlerRemainingBalls();
		} 
	} 
} 

class BowlerComparator implements Comparator<Bowler>{

	/**
	 * Method to check which bowler has higher no of bowls left
	 * @param b1 is bowler 1
	 * @param b2 is bowler 2
	 * @return int type value according to certain cases
	 */
	public int compare(Bowler b1, Bowler b2) { 
		if (b1.bowlerRemainingBalls < b2.bowlerRemainingBalls) 
			return 1; 
		else if (b1.bowlerRemainingBalls > b2.bowlerRemainingBalls) 
			return -1; 
		return 0; 
	} 
} 

class Bowler { 
	public int bowlerId; 
	public int bowlerRemainingBalls;

	/**
	 * Constructor of bowler class
	 * @param bowlerId should be of int type
	 * @param bowlerRemainingBalls should be of int type
	 */
	public Bowler(int bowlerId, int bowlerRemainingBalls) { 
	
		this.bowlerId = bowlerId; 
		this.bowlerRemainingBalls = bowlerRemainingBalls; 
	}

	/**
	 * Function That returns remaining bowls of bowler
	 * @return bowlerRemainingBalls
	 */
	public int getBowlerRemainingBalls() { 
		return bowlerRemainingBalls; 
	}

	/**
	 * Function to get bowler id
	 * @return bowlerId
	 */
	public int getbowlerId() { 
		return bowlerId; 
	} 
} 
