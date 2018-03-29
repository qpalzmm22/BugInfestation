package edu.handong.csee.java.lab06;

import java.util.*;
/**
 * This class implements bug Infestation. 
 * Given two values(house volume, start population of roaches),
 * we can find how long it takes given growth rate of roachse.
 * This class contains three methods(setInitialState(), calcBugWeek(), printResult())
 * @author qpalzmm22
 *
 */
public class BugInfestation {	
	final double GROWTH_RATE = 0.95;
	final double ONE_BUG_VOLUME = 0.002;
	double houseVolume;
	double startPopulation;
	int countWeeks;
	double population;
	double totalBugVolume;
	double newBugs;
	double newBugVolume;
	
	/**
	 * The setInitialState takes two inputs from user and set each of them to 
	 * houseVolume and startPopulation
	 */
	
	void setInitialState() {		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the total volume of your house in cubin feet: ");
		houseVolume = keyboard.nextDouble();
		System.out.print("Enter the estimated number of roaches in your house: ");
		startPopulation = keyboard.nextDouble();		
		
		population = startPopulation;	
		totalBugVolume = population * ONE_BUG_VOLUME;
		
		countWeeks = 0;
		
		keyboard.close();
	}
	
	/**
	 * The calcBugWeek calculates how many weeks it takes for bugs to fill the
	 * house 
	 */
	
	void calcBugWeek() {
		while(totalBugVolume < houseVolume) {
			newBugs = population * GROWTH_RATE;
			newBugVolume = newBugs * ONE_BUG_VOLUME;
			population += newBugs;
			totalBugVolume += newBugVolume;
			countWeeks = countWeeks + 1;
		}
	}
	
	/**
	 * The printResult prints the whole statements of how many bugs are in
	 * how big of a house. Also, the final number of the roaches and how many weeks it took for bugs to take over the house
	 */
	
	void printResult() {
		System.out.println("Starting with a roach population of " + (int)startPopulation);
		System.out.println("and a house with a volume of " + houseVolume + " cubic feet.");
		
		System.out.println("after " + countWeeks + " weeks.");
		System.out.println("the house will be filled with " + (int)population + " roaches");
		System.out.println("They will fill a volume of " + (int)totalBugVolume  + " cubic feet.");
		System.out.println("Better call Debugging Experts Inc.");
	}
	
	
	/**
	 * The main method calls setInitialState calcBugWeek printResult
	 * to perform the given task
	 * @param args
	 */
	public static void main(String args[]) {
		BugInfestation bug = new BugInfestation();
		
		bug.setInitialState();
		bug.calcBugWeek();
		bug.printResult();
	}
}
