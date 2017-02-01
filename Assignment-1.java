import java.util.Scanner;

/**
 * @author: Matthew Abraham
 * @id: 815009613
 * @date: Jan 19, 2017
 * @project: Assignment 1
 * 
 * @description: 	This program keeps track of how seven fruit trees ranked based on customer votes.
 * 					Also displays a menu with the proper functionality as per assignment description.
 * 
 * @remarks:		The program displays the menu as requested
 * 					The menu's options are all functional
 * 					I've written my own methods to implement options 2 - 5
 * 					I've written a method to draw the histogram for option 6
 */
public class Catalogue {

	public static final int NUM_TREES = 7;
	
	public static void main(String[] args) {
		
		// Declare, Create, Initialize Scanner Object
		Scanner s = new Scanner(System.in);
		
		// Declare, Create Fruit Arrays of size NUM_TREES
		String [] fruitNames = new String [NUM_TREES];
		int [] fruitVotes = new int [NUM_TREES];
		
		// Initialize Fruit Arrays
		fruitNames[0] = "Soursop";
		fruitNames[1] = "Pommerac";
		fruitNames[2] = "Five Fingers";
		fruitNames[3] = "Chennet";
		fruitNames[4] = "Starch Mango";
		fruitNames[5] = "West Indian Cherry";
		fruitNames[6] = "Sugar Apple";
		
		// Print the Menu to the Console
		printMenu();
		
		// Prompt user for an Initial Action
		System.out.print("\nWhat would you like to do?\t");
		int o = s.nextInt();
		
		while (o != 7) {
			if (o == 1) {
				printLegend(fruitNames);
				int v = 0;
				while (v < 1 || v > 7) {
					System.out.print("\nEnter a code to place a vote:\t");
					v = s.nextInt();
				}
				recordVote(fruitVotes, fruitNames, v);
			}
			else if (o == 2) {
				System.out.print("Enter the code of the fruit you would like to check:\t");
				int c = s.nextInt();
				printData(fruitNames, fruitVotes, c);
			}
			else if (o == 3) {
				mostPopularFruit2(fruitNames, fruitVotes);
			}
			else if (o == 4) {
				leastPopularFruit(fruitNames, fruitVotes);
			}
			else if (o == 5) {
				totalAverageVotes(fruitVotes);
			}
			else if (o == 6) {
				printHistogram(fruitNames, fruitVotes);
			}
			System.out.println("--------------------------------");
			System.out.print("What would you like to do next?:\t");
			o = s.nextInt();
		}
		s.close(); // Terminate Terminate Terminate
	}
	
	private static void printMenu() {
		String [] menuItems = {"1. Record a Vote", "2. Display the number of votes for a fruit tree (using Tree code)",
				"3. Display the top two fruit trees", "4. Display the least popular fruit tree",
				"5. Display the total number and average number of votes", "6. Display a histogram of votes (by fruit tree)",
				"7. Quit"};
		for (String s:menuItems)
			System.out.println(s);
	}

	private static void printLegend(String [] name) {
		int i = 0;
		System.out.println("\nCode\tName");
		for (String s:name) {
			System.out.println(i+"\t"+s);
			i++;
		}
	}

	private static void recordVote(int [] v, String [] n, int code) {
		System.out.println("You have placed one (1) vote for "+n[code-1]+"."); 
		v[code-1]+=1;
	}

	private static void printData(String[] n, int [] v, int c) {
		System.out.println(n[c-1]+" has "+v[c-1]+" vote(s).");
		
	}

	private static void mostPopularFruit2(String[] n, int [] v) {
	
		// Declare, Create, Initialize variables:
		int max = 0, max2 = 0;		// To store max votes
		int p = 0, p2 = 0;			// To store position
		
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max) {
				max2 = max;
				max = v[i];
				p2 = p;
				p = i;
			}
			else if (v[i] > max2) {
				max2 = i;
				p2 = i;
			}
		}
		System.out.println("Two top fruit trees:");
		System.out.println(n[p2]+"("+max2+")"+" and "+n[p]+"("+max+")");
		
	}

	private static void leastPopularFruit(String[] n, int[] v) {
		int min = v[0], p = 0;
		
		for (int i = 0; i < v.length; i++) {
			if (v[i] < min) {
				min = v[i];
				p = i;
			}
		}
		
		System.out.println(n[p]+"("+min+") is the least popular.");
	}

	private static void totalAverageVotes(int[] v) {
		int total = 0, average = 0;
		for (int i:v){
			total += i;
		}
		
		average = total / NUM_TREES;
		System.out.println("Total votes cast: "+total);
		System.out.println("Average votes: "+average);
	}

	private static void printHistogram(String[] n, int[] v) {
		System.out.print("Fruit Trees\t\tHistogram (Votes)");
		String l;		// Variable to append left side strings for formatting
		String a;		// Variable to append histogram votes
		for (int i = 0; i < v.length; i++) { // Traverse Fruit
			a = "";
			l = "\n"+(i+1)+". "+n[i];
			l = String.format("%"+-25+"s", l);
			System.out.print(l);
			
			for (int j = 0; j < v[i]; j++) { // Print * for (n) votes
				a += "*";
			}
			System.out.print(a);
		}
		System.out.println("\n");
	}

}
