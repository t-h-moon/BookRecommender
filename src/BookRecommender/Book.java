package BookRecommender;

import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Book {

	public static void main(String[] args) throws FileNotFoundException {
		String B[] = bookNames(); // call function and putting into new B array
		bookRating(); // to call functions
		int U[] = userRating(B); 
		int R[][] = bookRating();
		userSimilarity(U); 
		bookSimilarity(R);
		double userMath = userSimilarity(U);
		double PScores[] = bookSimilarity(R);
		both(R, U);  
		double both[] = both(R, U);
		Sum(both, PScores, userMath);
		double bookW[] = W(PScores, R);
		int[] bookIndex = bookFind(bookW, U); 
		bookFind(bookW, U);
		//System.out.println(Arrays.toString(bookIndex));
		String[] moreThanOneB = multBooks(bookIndex, B);
		System.out.println(Arrays.toString(moreThanOneB));
	}

	public static final int Books = 2;

//book names being imported to array
	public static String[] bookNames() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		Scanner books = new Scanner(new File("/Users/tinamoon/Desktop/hello.txt"));
		String[] B = new String[20];
		int count = 0; 
		while (books.hasNextLine()) {
			String line = books.nextLine();
			B[count] = line;
			count++;
		}
		return B;
	}

//book ratings imported into 2D array 
	public static int[][] bookRating() throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		Scanner rating = new Scanner(new File("/Users/tinamoon/Desktop/ratings.txt"));
		int[][] R = new int[30][20];
		int counter = 0;
		while (rating.hasNextLine() && counter < R.length) {
			String line = rating.nextLine();
			String[] A = line.split(" ");
			for (int j = 0; j < 20; j++) {
				R[counter][j] = Integer.parseInt(A[j]);
			}
			counter++;
		}
		return R;
	}

//user input ratings,  taking the user input and putting it into the array 
	public static int[] userRating(String B[]) {
		Scanner scan = new Scanner(System.in);
		int[] U = new int[20];
		for (int i = 0; i < U.length; i++) {
			U[i] = -1; 
		}
		for (int i = 0; i < 20; i++) {
			System.out.println("From 1 to 5, -1 if you have not read the book: what is your ratings for " + B[i]);
			U[i] = scan.nextInt();
		}
		return U; 
	}

//Similarity for the user
//power user index ^2 and square
	public static double userSimilarity(int U[]) {
		double userMath = 0; 
		for (int i = 0; i < U.length; i++) {
			if (i != -1) {
				userMath += Math.pow(U[i], 2);
			} 
		}
		double userTotal = Math.sqrt(userMath);	
		return userTotal;
	} 

//Similarity for the book rating
//power each person x and index ^2 and square
	public static double[] bookSimilarity(int R[][]) {
		double bookRatingMath = 0;
		double PScores[] = new double[R.length];
		for (int i = 0; i < R.length; i++) {  
			bookRatingMath = 0;
			for (int j = 0; j < R[i].length; j++) {
				if (R[i][j] != -1) {
					bookRatingMath += Math.pow(R[i][j], 2);
				}
			}
			double bookRatingTotal = Math.sqrt(bookRatingMath);
			PScores[i] = bookRatingTotal;
		}
		return PScores;
	}

//multiplying the book that the user and person x has read
	public static double[] both(int R[][], int U[]) {
		double[] both = new double[30];
		double[] bothSum = new double[30];
		for (int i = 0; i < both.length; i++) {
			both[i] = 0.0;
		}
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[i].length; j++) {
				if (R[i][j] != -1 && U[j] != -1) {
					both[i] += R[i][j] * U[j];
				}
			}
		}
		return both;
	}
//dividing the sum with user and person x
	public static double[] Sum(double both[], double PScores[], double userMath) {
		double bothSum[] = new double[both.length];
		for (int i = 0; i < both.length; i++) { 
			bothSum[i] = both[i] / (PScores[i] * userMath);
		}
		// System.out.println(Arrays.toString(bothSum));
		return bothSum;
	}

//weighted score formula: the sum of all columns
	public static double[] W(double PScores[], int R[][]) {
		double bookW[] = new double[20];
		for (int col = 0; col < R[0].length; col++) {
			double sum = 0;
			for (int row = 0; row < R.length; row++) {
				if (R[row][col] == -1) {
				} else {
					sum += PScores[col] * R[row][col];
				}
			}
			bookW[col] = sum;
		}
		// System.out.println(Arrays.toString(bookW));
		return bookW;
	}
//using the scores from the weight to find the index of the book 
	public static int[] bookFind(double bookW[], int U[]) {
		int[] N = new int[Books];//holding the top scores index
		for (int x = 0; x < N.length; x++) {
			double highestNum = 0; // will hold the highest score in bookW
			for (int i = 0; i < U.length; i++) {
				if (U[i] == -1 && highestNum < bookW[i]) {//checking all the users -1 
					highestNum = bookW[i]; // bookW index is going into highestNum, to compare highest score
					N[x] = i;
				}
			}
			bookW[N[x]] = 0;
		}
		return N;//top scores index
	}
//taking in the top three scores of the bookFind and returning the returning the index
	public static String[] multBooks(int bookFind[], String[] B) {
		String[] moreThanOneB = new String[Books];
		for (int i = 0; i < Books; i++) { 
			moreThanOneB[i] = B[bookFind[i]];
		}
		return moreThanOneB;
	}
}
