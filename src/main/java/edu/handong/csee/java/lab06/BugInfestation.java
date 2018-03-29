package edu.handong.csee.java.lab06;	// makes this class a package of following package

import java.util.*;	//import to user Scanner();
/**
 * This class implements bug Infestation. 
 * Given two values(house volume, start population of roaches),
 * we can find how long it takes given growth rate of roachse.
 * This class contains three methods(setInitialState(), calcBugWeek(), printResult())
 * @author qpalzmm22
 *
 */
public class BugInfestation {				// class for calculating how many weeks bugs takes to overflow the house for given values
	final double GROWTH_RATE = 0.95;		// constant growing value for bugs
	final double ONE_BUG_VOLUME = 0.002;	// constant bug size
	double houseVolume;						// user-given house volume
	double startPopulation;					// user-given start population of roaches
	int countWeeks;							// variable to count how many weeks it took
	double population;						// current population(while calculating) of roaches 
	double totalBugVolume;					// final value of population when the roaches overflew the house
	double newBugs;							// variable to save number of roaches(while calculating)
	double newBugVolume;					// variable to save size of bug(while calculating)
	
	/**
	 * The setInitialState takes two inputs from user and set each of them to 
	 * houseVolume and startPopulation
	 */
	
	void setInitialState() {			// This method gets two inputs from user (houseVolume and startPopulation) 
		Scanner keyboard = new Scanner(System.in);	// initialize Scanner to use nextDouble()
			
		System.out.print("Enter the total volume of your house in cubin feet: ");	// ask user for houseVolume
		houseVolume = keyboard.nextDouble();										// gets value for houseVolume
		System.out.print("Enter the estimated number of roaches in your house: ");	// ask user for startPopulation of bugs
		startPopulation = keyboard.nextDouble();									// gets value for startPopulation
		
		population = startPopulation;					// at week 0, population = startPopulation
		totalBugVolume = population * ONE_BUG_VOLUME;	// and totalBugVolume is the size of one bug * number of bugs
			
		countWeeks = 0;		// week = 0
		
		keyboard.close();	// close keyboard to prevent information leaking
	}
	
	/**
	 * The calcBugWeek calculates how many weeks it takes for bugs to fill the
	 * house 
	 */
	
	void calcBugWeek() {							// this method increase bug until Volume of the bugs exeed volume of the house
		while(totalBugVolume < houseVolume) {		// check if the houseVolume is smaller than total Bug Volume 
			newBugs = population * GROWTH_RATE;		// new bugs are created by growth_rate much
			newBugVolume = newBugs * ONE_BUG_VOLUME;// the size of new bugs
			population += newBugs;					// results current population
			totalBugVolume += newBugVolume;			// results current size of bugs
			countWeeks = countWeeks + 1;			// increase week
		}
	}
	
	/**
	 * The printResult prints the whole statements of how many bugs are in
	 * how big of a house. Also, the final number of the roaches and how many weeks it took for bugs to take over the house
	 */
	
	void printResult() {
		System.out.println("Starting with a roach population of " + (int)startPopulation);		// print given population
		System.out.println("and a house with a volume of " + houseVolume + " cubic feet.");		// print given volume
		
		System.out.println("after " + countWeeks + " weeks.");									// print how many weeks it took
		System.out.println("the house will be filled with " + (int)population + " roaches");	// print how many roaches are there after the calculation
		System.out.println("They will fill a volume of " + (int)totalBugVolume  + " cubic feet.");	// print how big the bug size is after calculation
		System.out.println("Better call Debugging Experts Inc.");									// print funny joke
	}
	
	
	/**
	 * The main method calls setInitialState calcBugWeek printResult
	 * to perform the given task
	 * @param args
	 */
	public static void main(String args[]) {		// main method to test if the class is working
		BugInfestation bug = new BugInfestation();	// initialize BugInfestation to use methods of it
		
		bug.setInitialState();					// gets essential values from user and set them so that it can start calculation
		bug.calcBugWeek();						// calculate how long it takes for bugs to dominate the house
		bug.printResult();						// print the after-result
	}
}
